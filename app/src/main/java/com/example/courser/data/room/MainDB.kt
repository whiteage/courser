package com.example.courser.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [
        CourseEntityRoom::class
    ],
    version = 1
)
abstract class MainDB  : RoomDatabase(){
    abstract val dap : DAO

    companion object{
        fun createDataBase(context: Context) : MainDB{
            return Room.databaseBuilder(context, MainDB::class.java, "courses.db").build()
        }

    }
}