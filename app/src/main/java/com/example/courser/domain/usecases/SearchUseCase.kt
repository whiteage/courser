package com.example.courser.domain.usecases

import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.repository.CoursesRepository

class SearchUseCase (private val repository: CoursesRepository) {
    suspend fun searchCourses(string: String) : List<CourseItemEntity> {
        return repository.searchCourses(string)
    }
}