package com.example.courser.domain.usecases

import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.repository.CoursesRepository

class GetAllCoursesUseCase (private val repository: CoursesRepository) {
    suspend fun getAllCourses() {
        return repository.getAllCourses()
    }
}