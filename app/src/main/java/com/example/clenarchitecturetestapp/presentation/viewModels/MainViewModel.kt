package com.example.clenarchitecturetestapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clenarchitecturetestapp.domain.model.SaveUserNameParam
import com.example.clenarchitecturetestapp.domain.useсase.GetUserNameUseCase
import com.example.clenarchitecturetestapp.domain.useсase.SaveUserNameUseCase

class MainViewModel(
    private val getUserUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase

) : ViewModel() {

      private val privateResultLive = MutableLiveData<String>()
      val publicResultLive : LiveData<String> = privateResultLive


    override fun onCleared() {
        super.onCleared()
    }

    fun save(text: String) {
        val param = SaveUserNameParam(text)
        val resultData: Boolean = saveUserNameUseCase.excute(params = param)
        privateResultLive.value = "Save result =  $resultData"
    }

    fun load() {
        val userName = getUserUseCase.excute()
        privateResultLive.value = "${userName.firstName} ${userName.lastName}"
    }
}