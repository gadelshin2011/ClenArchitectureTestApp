package com.example.clenarchitecturetestapp.domain.useсase

import com.example.clenarchitecturetestapp.domain.model.UserName
import com.example.clenarchitecturetestapp.domain.repository.UserRepository

class GetUserNameUseCase (private val userRepository: UserRepository) {
    fun excute(): UserName {

        return userRepository.getName()
    }
    //  тестовая логика, данные могут браться их других источников, например бд, апи и тд
}