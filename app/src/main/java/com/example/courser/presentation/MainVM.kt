package com.example.courser.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.usecases.AuthUseCase
import com.example.courser.domain.usecases.FilterUseCase
import com.example.courser.domain.usecases.GetAllCoursesFromDbUseCase
import com.example.courser.domain.usecases.GetAllCoursesUseCase
import com.example.courser.domain.usecases.GetAllLikedUseCase
import com.example.courser.domain.usecases.SetFavouriteUseCase
import com.example.courser.presentation.entity.SortOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val getAllCoursesUseCase: GetAllCoursesUseCase,
    private val getAllLikedCourses: GetAllLikedUseCase,
    private val getAllCoursesFromDbUseCase : GetAllCoursesFromDbUseCase,
    private val filterBy : FilterUseCase,
    private val auth : AuthUseCase,
    private val setFavourite : SetFavouriteUseCase,
    application: Application
) : AndroidViewModel(application) {


    private val _sortedState = MutableLiveData<Boolean>(false)


    private val _readyToLogin = MutableLiveData<Boolean>()
    val readyToLogin : LiveData<Boolean> = _readyToLogin

    suspend fun getAllCourses(){
        getAllCoursesUseCase.getAllCourses()
    }

    private val sortOrder = MutableStateFlow(SortOrder.NONE)

    private val coursesFlow: Flow<List<CourseItemEntity>> = getAllCoursesFromDbUseCase()

    val courses: StateFlow<List<CourseItemEntity>> = combine(
        coursesFlow,
        sortOrder
    ) { courses, sort ->
        when (sort) {
            SortOrder.BY_DESC-> courses.sortedBy { it.publishDate }
            SortOrder.NONE -> courses
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())



    val likedCourses : StateFlow<List<CourseItemEntity>> = getAllLikedCourses()
        .stateIn(viewModelScope,SharingStarted.WhileSubscribed(5000), emptyList())

    fun login(loginn : String, password : String){
        val logged = auth.auth(loginn, password)
        _readyToLogin.postValue(logged)
    }

    init {
        viewModelScope.launch {
            getAllCourses()

        }
    }

    fun setLike(item : CourseItemEntity){
        viewModelScope.launch {
            setFavourite.setFavourite(item)
        }
    }


    fun toggleSort(){
        sortOrder.update {
            when (it) {
                SortOrder.NONE -> SortOrder.BY_DESC
                SortOrder.BY_DESC -> SortOrder.NONE
            }
        }
    }
}