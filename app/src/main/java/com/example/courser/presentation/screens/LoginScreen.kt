package com.example.courser.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.courser.R
import com.example.courser.presentation.MainVM
import com.example.courser.presentation.navigation.Screens
import okhttp3.internal.wait

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel : MainVM, navHostController: NavHostController) {

    val logged = viewModel.readyToLogin.observeAsState(false)
    val email = remember { mutableStateOf("") }
    val pass = remember { mutableStateOf("") }

    LaunchedEffect(email.value, pass.value) {
        viewModel.login(email.value,pass.value)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(140.dp))

        Text(
            text = "Вход",
            modifier = Modifier.align(Alignment.Start),
            fontSize = 28.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Email",
            modifier = Modifier.align(Alignment.Start),
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = email.value,
            onValueChange = { newValue -> email.value = newValue },
            placeholder = { Text("example@gmail.com") },
            singleLine = true,
            shape = RoundedCornerShape(18.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFF1E1E1E),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Пароль",
            modifier = Modifier.align(Alignment.Start),
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = pass.value,
            onValueChange = { pass.value = it},
            placeholder = { Text("Введите пароль") },
            singleLine = true,
            shape = RoundedCornerShape(18.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFF1E1E1E),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),


            )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                Log.d("Login", "${logged.value}")
                      if(logged.value){
                          navHostController.navigate(Screens.MainScreen.route)
                      }

                      },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF12B956))
        ) {
            Text("Вход", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Нету аккаунта?", color = Color.White)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Регистрация",
                color = Color(0xFF00C853),
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { /* едем в регистрацию */ }
            )
        }

        Text(
            text = "Забыл пароль",
            color = Color(0xFF00C853),
            modifier = Modifier
                .padding(top = 8.dp)
                .clickable { /* едем в забыли пароль */ }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Divider(color = Color.DarkGray)

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* VK login */ },
                colors = ButtonDefaults.buttonColors(Color(0xFF2683ED)),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .padding(end = 8.dp),
                shape = RoundedCornerShape(25.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_vk), "vk", tint = Color.White)
            }

            Button(
                onClick = { /* OK login */ },
                colors = ButtonDefaults.buttonColors(Color(0xFFF95D00)),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .padding(start = 8.dp),
                shape = RoundedCornerShape(25.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_ok), "ok", tint = Color.White)
            }
        }
    }
}
