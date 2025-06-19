package com.example.courser.domain.repository

import com.example.courser.domain.entity.CourseItemEntity
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
    fun auth(login : String, password : String) : Boolean
    suspend fun filterBy() : List<CourseItemEntity>
    suspend fun  getAllCourses()
    suspend fun searchCourses(string : String) : List<CourseItemEntity>
    suspend fun setFavourite(cetegory : CourseItemEntity)
    fun getAllCoursesFromDB() : Flow<List<CourseItemEntity>>
    fun getAllLiked() : Flow<List<CourseItemEntity>>


}