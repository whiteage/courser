package com.example.courser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.courser.data.repository.CoursesRepositoryImpl
import com.example.courser.data.rss.Dto
import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.usecases.GetAllCoursesUseCase
import com.example.courser.presentation.MainVM
import com.example.courser.presentation.navigation.Navigation
import com.example.courser.presentation.screens.LoginScreen
import com.example.courser.presentation.screens.MainScreen
import com.example.courser.ui.theme.CourserTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainVM::class.java]
        enableEdgeToEdge()
        setContent {
            Navigation(viewModel)

        }
    }
}
