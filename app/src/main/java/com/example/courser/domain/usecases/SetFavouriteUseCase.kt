package com.example.courser.domain.usecases

import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.repository.CoursesRepository

class SetFavouriteUseCase (private val repository: CoursesRepository) {
    suspend fun setFavourite(cetegory : CourseItemEntity) {
        return repository.setFavourite(cetegory)
}}