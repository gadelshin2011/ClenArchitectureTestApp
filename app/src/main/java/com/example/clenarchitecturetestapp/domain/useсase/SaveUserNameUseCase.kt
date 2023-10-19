package com.example.clenarchitecturetestapp.domain.useсase

import com.example.clenarchitecturetestapp.domain.model.SaveUserNameParam
import com.example.clenarchitecturetestapp.domain.repository.UserRepository

class SaveUserNameUseCase (private val userRepository : UserRepository) {
    fun excute(params: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()
        return if (oldUserName.firstName == params.userName|| params.userName.isEmpty()) {
            false
        } else {
            val result: Boolean = userRepository.saveName(saveParam = params)
            result
        }


    }
}