package com.example.courser.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Courses")
data class CourseEntityRoom(
    @PrimaryKey val id : Int,
    val title : String,
    val text : String,
    val price : String,
    val rate : String,
    val startDate : String,
    val hasLike : Boolean,
    val publishDate : String,
)
