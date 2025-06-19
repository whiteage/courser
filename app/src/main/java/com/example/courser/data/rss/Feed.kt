package com.example.courser.data.rss

import com.example.courser.domain.entity.CourseItemEntity
import java.util.Date

data class CoursesResponse(
    val courses: List<Feed>
)

data class Feed(
    val id : Int,
    val title : String,
    val text : String,
    val price : String,
    val rate : String,
    val startDate : String,
    val hasLike : Boolean,
    val publishDate : String,
) {

}