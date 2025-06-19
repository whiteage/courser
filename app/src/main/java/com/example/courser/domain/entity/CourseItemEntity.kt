package com.example.courser.domain.entity

import java.util.Date

data class CourseItemEntity(
    val id : Int,
    val title : String,
    val text : String,
    val price : String,
    val rate : String,
    val startDate : String,
    val hasLike : Boolean,
    val publishDate : String,
)
