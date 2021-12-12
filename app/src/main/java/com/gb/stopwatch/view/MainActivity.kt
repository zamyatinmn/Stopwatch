package com.gb.stopwatch.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.stopwatch.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.liveData.observe(this, { binding.textTime.text = it })

        binding.buttonStart.setOnClickListener { viewModel.start() }
        binding.buttonPause.setOnClickListener { viewModel.pause() }
        binding.buttonStop.setOnClickListener { viewModel.stop() }
    }
}