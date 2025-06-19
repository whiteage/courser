package com.example.courser.presentation.screens

import android.util.Log
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
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import com.example.courser.presentation.MainVM
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.courser.presentation.navigation.Screens

@Composable
fun MainScreen(viewModel: MainVM, navHostController: NavHostController) {

    LaunchedEffect(Unit) {
        viewModel.getAllCourses()
    }


    val currentRoute = navHostController.currentBackStackEntryAsState().value?.destination?.route

    val news = viewModel.courses.collectAsState()

    Scaffold(
        containerColor = Color(0xFF121212),
        bottomBar =
        {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = Color(0xFF1E1E1E)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Outlined.Home, contentDescription = "Главная", tint = if(currentRoute == Screens.MainScreen.route){ Color.Green} else{Color.White})
                    Text(text = "Главная", color = if(currentRoute == Screens.MainScreen.route){ Color.Green} else{Color.White} , fontFamily = FontFamily.SansSerif)
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.BookmarkBorder, contentDescription = "Избранное", tint = if(currentRoute == Screens.Favourite.route){ Color.Green} else{Color.White})
                    Text(text = "Избранное", color = if(currentRoute == Screens.Favourite.route){ Color.Green} else{Color.White} , fontFamily = FontFamily.SansSerif)
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.Person, contentDescription = "Аккаунт", tint = Color.White)
                    Text(text = "Аккаунт", color = Color.White, fontFamily = FontFamily.SansSerif )
                }
            }}


    )

    {
        innerpadding ->

        if(news.value.isNotEmpty()){
            Column (modifier = Modifier.padding(innerpadding).fillMaxSize() ) {
                TopBar()
                Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(bottom = 10.dp).clickable { viewModel.filterTime() }) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text("По дате добавления", color = Color(0xFF12B956))
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.SwapVert,
                        contentDescription = "Сортировка",
                        modifier = Modifier.size(16.dp),
                        tint = Color(0xFF12B956)
                    )
                }
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    itemsIndexed(items = news.value) { _, item ->
                        CourseCard(item)


                    }
                }
            }
        }
    }


}