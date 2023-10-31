package com.example.clenarchitecturetestapp.data.storage

import com.example.clenarchitecturetestapp.data.storage.model.User
import com.example.clenarchitecturetestapp.domain.model.SaveUserNameParam
import com.example.clenarchitecturetestapp.domain.model.UserName

interface UserStorage {
    fun save(user: User) : Boolean

    fun get(): User
}