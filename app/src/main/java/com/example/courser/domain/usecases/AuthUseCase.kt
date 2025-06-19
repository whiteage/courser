package com.example.courser.domain.usecases

import com.example.courser.domain.repository.CoursesRepository
import javax.inject.Inject

class AuthUseCase@Inject constructor(private val repository: CoursesRepository ) {

     fun auth(login : String, password : String) : Boolean {
        return repository.auth(login, password)
    }
}