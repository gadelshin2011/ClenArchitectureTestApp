package com.example.clenarchitecturetestapp.presentation.fragments


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clenarchitecturetestapp.databinding.FragmentMainBinding
import com.example.clenarchitecturetestapp.presentation.viewModels.MainViewModel
import com.example.clenarchitecturetestapp.presentation.viewModels.MainViewModelFactory

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, MainViewModelFactory(requireContext().applicationContext))[MainViewModel::class.java]
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

        viewModel.publicResultLive.observe(this.viewLifecycleOwner, { text ->
            binding.getDataTv.text =  text
        })


        with(binding) {
            getDataButton.setOnClickListener {
                viewModel.load()
            }
            saveDataButton.setOnClickListener {
                val text = saveDataEt.text.toString()
                viewModel.save(text)
//                when(viewModel.save(text).isNotEmpty()){
//                    true -> Toast.makeText(context, "true", Toast.LENGTH_SHORT).show()
//                    false -> Toast.makeText(context, "false", Toast.LENGTH_SHORT).show()
//                }
            }
        }


    }

}
