package com.example.courser.DI

import android.content.Context
import androidx.room.Room
import com.example.courser.data.repository.CoursesRepositoryImpl
import com.example.courser.data.room.DAO
import com.example.courser.data.room.MainDB
import com.example.courser.domain.repository.CoursesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)


object ApplicationComponent {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext appContext: Context) : MainDB{
        return Room.databaseBuilder(
            appContext,
            MainDB::class.java,
            "courses.db").build()

    }
    @Provides
    fun provideUserDao(db: MainDB): DAO {
        return db.dap}

    @Provides
    @Singleton
    fun provideNewsRepository(dao: DAO): CoursesRepository {
        return CoursesRepositoryImpl(dao)
    }

}
