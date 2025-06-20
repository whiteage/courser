package com.example.courser.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.courser.presentation.MainVM
import com.example.courser.presentation.navigation.Screens


@Composable
fun FavouriteScreen(navHostController : NavHostController, viewModel : MainVM) {

    val news = viewModel.likedCourses.collectAsState()

    Scaffold(
        containerColor = Color(0xFF121212),
        bottomBar =
        {
            BottomBar(navHostController)
        }


    )
    {
            innerpadding ->

        if(news.value.isNotEmpty()){
            Column (modifier = Modifier.padding(innerpadding).fillMaxSize() ) {
                Text(text = "Избранное", modifier = Modifier.padding(top = 16.dp, start = 16.dp), color = Color.White, fontFamily = FontFamily.SansSerif, fontSize = 28.sp)
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    itemsIndexed(items = news.value) { _, item ->
                        CourseCard(item,viewModel)


                    }
                }
            }
        }
        else{
            Column (modifier = Modifier.padding(innerpadding).fillMaxSize() ) {
                Text(
                    text = "Избранное",
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 28.sp
                )
            }
        }
    }

}