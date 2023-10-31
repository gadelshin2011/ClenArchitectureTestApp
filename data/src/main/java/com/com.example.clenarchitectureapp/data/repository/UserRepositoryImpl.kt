package com.example.clenarchitecturetestapp.data.repository

import com.example.clenarchitecturetestapp.data.storage.model.User
import com.example.clenarchitecturetestapp.data.storage.UserStorage
import com.example.clenarchitecturetestapp.domain.model.SaveUserNameParam
import com.example.clenarchitecturetestapp.domain.model.UserName
import com.example.clenarchitecturetestapp.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage : UserStorage) : UserRepository {


    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User) : UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.userName , lastName = "")
    }
}