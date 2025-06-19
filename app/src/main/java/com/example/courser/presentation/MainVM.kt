package com.example.courser.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.courser.data.repository.CoursesRepositoryImpl
import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.usecases.AuthUseCase
import com.example.courser.domain.usecases.FilterUseCase
import com.example.courser.domain.usecases.GetAllCoursesFromDbUseCase
import com.example.courser.domain.usecases.GetAllCoursesUseCase
import com.example.courser.domain.usecases.GetAllLikedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainVM() : ViewModel() {


    val repository = CoursesRepositoryImpl(dao = )
    val getAllCoursesUseCase = GetAllCoursesUseCase(repository)
    val getAllLikedCourses = GetAllLikedUseCase(repository)
    val getAllCoursesFromDbUseCase = GetAllCoursesFromDbUseCase(repository)
    val filterBy = FilterUseCase(repository)
    val auth = AuthUseCase(repository)


    private val _sortedState = MutableLiveData<Boolean>(false)

    private val _filteredCourses = MutableStateFlow<List<CourseItemEntity>>(emptyList())
    val filteredCourses: StateFlow<List<CourseItemEntity>> = _filteredCourses.asStateFlow()


    private val _readyToLogin = MutableLiveData<Boolean>()
    val readyToLogin : LiveData<Boolean> = _readyToLogin

    suspend fun getAllCourses(){
        getAllCoursesUseCase.getAllCourses()
    }

    val courses: StateFlow<List<CourseItemEntity>> = getAllCoursesFromDbUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val likedCourses : StateFlow<List<CourseItemEntity>> = getAllLikedCourses()
        .stateIn(viewModelScope,SharingStarted.WhileSubscribed(5000), emptyList())

    fun login(loginn : String, password : String){
        val logged = auth.auth(loginn, password)
        _readyToLogin.postValue(logged)
    }

    init {
        viewModelScope.launch {
            val initialList = getAllCoursesFromDbUseCase().first()
            _filteredCourses.value = initialList
        }
    }


     fun filterTime() {
         viewModelScope.launch {
             val newState = !_sortedState.value!!
             _sortedState.postValue(newState)

             val newList = if (newState) {
                 getAllCoursesFromDbUseCase().first()
             } else{
                 filterBy.filterBy()
             }
             _filteredCourses.value = newList
         }
    }
}