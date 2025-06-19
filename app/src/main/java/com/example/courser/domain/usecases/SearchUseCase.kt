package com.example.courser.domain.usecases

import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.repository.CoursesRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repository: CoursesRepository) {
    suspend fun searchCourses(string: String) : List<CourseItemEntity> {
        return repository.searchCourses(string)
    }
}