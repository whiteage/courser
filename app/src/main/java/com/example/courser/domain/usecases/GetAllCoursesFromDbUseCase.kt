package com.example.courser.domain.usecases

import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.repository.CoursesRepository
import kotlinx.coroutines.flow.Flow



class GetAllCoursesFromDbUseCase (private val repository: CoursesRepository) {
    operator fun invoke() : Flow<List<CourseItemEntity>> {
        return repository.getAllCoursesFromDB()
    }
}