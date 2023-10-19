package com.example.clenarchitecturetestapp.presentation.fragments

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.clenarchitecturetestapp.R
import com.example.clenarchitecturetestapp.data.repository.UserRepositoryImpl
import com.example.clenarchitecturetestapp.databinding.FragmentMainBinding
import com.example.clenarchitecturetestapp.domain.model.SaveUserNameParam
import com.example.clenarchitecturetestapp.domain.model.UserName
import com.example.clenarchitecturetestapp.domain.repository.UserRepository
import com.example.clenarchitecturetestapp.domain.useсase.GetUserNameUseCase
import com.example.clenarchitecturetestapp.domain.useсase.SaveUserNameUseCase
import com.example.clenarchitecturetestapp.presentation.viewModels.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val userRepository by lazy { UserRepositoryImpl(context = requireContext().applicationContext) }
    private val getUserUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            getDataButton.setOnClickListener {
                val userName = getUserUseCase.excute()
                getDataTv.text = "${userName.firstName} ${userName.lastName}"
            }
            saveDataButton.setOnClickListener {
                val textData = saveDataTv.text.toString()
                val param = SaveUserNameParam(textData)
                val result: Boolean = saveUserNameUseCase.excute(params = param)
                Toast.makeText(context, "$result", Toast.LENGTH_SHORT).show()
            }
        }


    }

}