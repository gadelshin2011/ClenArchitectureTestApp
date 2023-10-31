package com.example.clenarchitecturetestapp.presentation.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clenarchitecturetestapp.data.repository.UserRepositoryImpl
import com.example.clenarchitecturetestapp.data.storage.sharedPref.SharedPrefUserStorage
import com.example.clenarchitecturetestapp.domain.useсase.GetUserNameUseCase
import com.example.clenarchitecturetestapp.domain.useсase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userRepository by lazy {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(
                context = context
            )
        )
    }
    private val getUserUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserUseCase = getUserUseCase,
            saveUserNameUseCase = this.saveUserNameUseCase,
        ) as T
    }
}