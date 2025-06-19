package com.example.courser.domain.usecases

import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.repository.CoursesRepository
import javax.inject.Inject

class FilterUseCase@Inject constructor(private val repository: CoursesRepository) {

    suspend fun filterBy() : List<CourseItemEntity>{
        return repository.filterBy()
    }
}