package com.example.courser.domain.usecases

import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.repository.CoursesRepository
import javax.inject.Inject

class SetFavouriteUseCase @Inject constructor(private val repository: CoursesRepository) {
    suspend fun setFavourite(cetegory : CourseItemEntity) {
        return repository.setFavourite(cetegory)
}}