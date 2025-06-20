package com.example.courser.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.courser.R
import com.example.courser.presentation.navigation.Screens


@Composable
fun BottomBar(navHostController: NavHostController ) {
    val currentRoute = navHostController.currentBackStackEntryAsState().value?.destination?.route

    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xFF24252A)
    ) {
        Column(
            modifier = Modifier.weight(1f).clickable { navHostController.navigate(Screens.MainScreen.route) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier =if(currentRoute == Screens.MainScreen.route){ Modifier
                    .clip(shape = CircleShape)
                    .height(32.dp)
                    .width(64.dp)
                    .background(Color(0xFF32333A) )}
                else{ Modifier.height(32.dp)
                    .width(64.dp)}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "Главная",
                    modifier = Modifier.align(Alignment.Center),
                    tint = if (currentRoute == Screens.MainScreen.route) {
                        Color.Green
                    } else {
                        Color.White
                    }
                )
            }

            Text(
                text = "Главная", color = if (currentRoute == Screens.MainScreen.route) {
                    Color.Green
                } else {
                    Color.White
                }, fontFamily = FontFamily.SansSerif
            )
        }
        Column(
            modifier = Modifier.weight(1f)
                .clickable { navHostController.navigate(Screens.Favourite.route) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier =if(currentRoute == Screens.Favourite.route){ Modifier
                    .clip(shape = CircleShape)
                    .height(32.dp)
                    .width(64.dp)
                    .background(Color(0xFF32333A) )}
                else{ Modifier.height(32.dp)
                    .width(64.dp)}
            ) {
            Icon(
                Icons.Default.BookmarkBorder,
                contentDescription = "Избранное",
                modifier = Modifier.align(Alignment.Center),
                tint = if (currentRoute == Screens.Favourite.route) {
                    Color.Green
                } else {
                    Color.White
                }
            )}
            Text(
                text = "Избранное", color = if (currentRoute == Screens.Favourite.route) {
                    Color.Green
                } else {
                    Color.White
                }, fontFamily = FontFamily.SansSerif
            )
        }
        Column(
            modifier = Modifier.weight(1f).clickable { navHostController.navigate(Screens.Account.route) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier =if(currentRoute == Screens.Account.route){ Modifier
                    .clip(shape = CircleShape)
                    .height(32.dp)
                    .width(64.dp)
                    .background(Color(0xFF32333A) )}
                else{ Modifier.height(32.dp)
                    .width(64.dp)}
            ) {
            Icon(
                painter = painterResource(R.drawable.ic_account),
                contentDescription = "Аккаунт",
                modifier = Modifier.align(Alignment.Center),
                tint = Color.White
            )}
            Text(
                text = "Аккаунт", color = if (currentRoute == Screens.Account.route) {
                    Color.Green
                } else {
                    Color.White
                }, fontFamily = FontFamily.SansSerif
            )
        }
    }
}