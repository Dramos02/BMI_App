package com.example.bmi_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi_app.databinding.ActivityBmioutputScreenBinding

class BMIOutputScreen : AppCompatActivity() {
    private lateinit var binding: ActivityBmioutputScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmioutputScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}