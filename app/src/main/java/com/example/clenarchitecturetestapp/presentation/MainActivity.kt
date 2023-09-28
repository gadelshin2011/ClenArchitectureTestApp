package com.example.clenarchitecturetestapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clenarchitecturetestapp.R
import com.example.clenarchitecturetestapp.databinding.ActivityMainBinding
import com.example.clenarchitecturetestapp.presentation.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}