package com.example.courser.domain.usecases

import com.example.courser.domain.repository.CoursesRepository

class AuthUseCase(private val repository: CoursesRepository ) {

     fun auth(login : String, password : String) : Boolean {
        return repository.auth(login, password)
    }
}