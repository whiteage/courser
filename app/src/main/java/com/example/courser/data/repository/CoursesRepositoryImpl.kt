package com.example.courser.data.repository

import com.example.courser.data.room.CourseEntityRoom
import com.example.courser.data.room.DAO
import com.example.courser.data.rss.CoursesResponse
import com.example.courser.data.rss.RetrofitInstance
import com.example.courser.domain.entity.CourseItemEntity
import com.example.courser.domain.repository.CoursesRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class CoursesRepositoryImpl(private val dao: DAO) : CoursesRepository {
    val jsonUrl = "https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download"
    val api = RetrofitInstance.api

    private fun CourseEntityRoom.toDomain(): CourseItemEntity {
        return CourseItemEntity(
            id = this.id,
            title = this.title,
            text = this.text,
            price = this.price,
            rate = this.rate,
            startDate = this.startDate,
            hasLike = this.hasLike,
            publishDate = this.publishDate
        )
    }


    private fun CourseItemEntity.toRoomEntity(): CourseEntityRoom {
        return CourseEntityRoom(
            id = this.id,
            title = this.title,
            text = this.text,
            price = this.price,
            rate = this.rate,
            startDate = this.startDate,
            hasLike = this.hasLike,
            publishDate = this.publishDate
        )
    }

    override fun auth(login: String, password: String): Boolean {
        val pattern = "^[^@]+@[^@]+\\.[^@]+$".toRegex()
        return password.isNotEmpty() && pattern.matches(login)
    }

    override suspend fun filterBy(): List<CourseItemEntity> {
        return dao.getCoursesOrderedByDate().map { it.toDomain() }
    }

    suspend fun insertIntoDB(course: CourseItemEntity) {
        dao.insertIntoDB(course.toRoomEntity())
    }

    override suspend fun getAllCourses(){
        val response = api.downloadJson(jsonUrl)
        val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("ru"))
        if (response.isSuccessful) {
            val jsonString = response.body()?.string()
            if (!jsonString.isNullOrEmpty()) {
                val gson = Gson()
                val dto = gson.fromJson(jsonString, CoursesResponse::class.java)
                val courses = dto.courses.map { courseDto ->
                    CourseItemEntity(
                        id = courseDto.id,
                        text = courseDto.text,
                        title = courseDto.title,
                        price = courseDto.price,
                        rate = courseDto.rate,
                        startDate = LocalDate.parse(courseDto.startDate).format(formatter),
                        hasLike = courseDto.hasLike,
                        publishDate = courseDto.publishDate
                    )
                }
                courses.forEach { insertIntoDB(it) }
            }
        }
    }

    override fun getAllCoursesFromDB() : Flow<List<CourseItemEntity>> {
        return dao.getAllCourses().map { entityList ->
            entityList.map { it.toDomain() }
        }
    }

    override fun getAllLiked(): Flow<List<CourseItemEntity>> {
        return dao.getCoursesByLike().map { entityList ->
            entityList.map { it.toDomain() }
        }
    }

    override suspend fun searchCourses(string: String): List<CourseItemEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun setFavourite(category: CourseItemEntity) {
        val newItem = category.copy(hasLike = !category.hasLike)
        dao.updateItem(newItem.toRoomEntity())
    }
}
