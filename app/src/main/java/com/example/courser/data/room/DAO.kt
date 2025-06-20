package com.example.courser.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIntoDB(course : CourseEntityRoom)

    @Update
    suspend fun updateItem( course: CourseEntityRoom)

    @Query("SELECT * FROM  Courses")
    fun getAllCourses() : Flow<List<CourseEntityRoom>>

    @Query("SELECT * FROM Courses WHERE hasLike = 1")
    fun getCoursesByLike(): Flow<List<CourseEntityRoom>>

    @Query("SELECT * FROM Courses ORDER BY publishDate DESC")
    suspend fun getCoursesOrderedByDate(): List<CourseEntityRoom>



}