package com.example.clenarchitecturetestapp.domain.repository

import com.example.clenarchitecturetestapp.domain.model.SaveUserNameParam
import com.example.clenarchitecturetestapp.domain.model.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam):Boolean
    fun getName(): UserName

}