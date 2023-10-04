package com.example.bmi_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi_app.databinding.ActivityBmioutputScreenBinding
import android.graphics.Color

class BMIOutputScreen : AppCompatActivity() {
    private lateinit var binding: ActivityBmioutputScreenBinding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmioutputScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val firstname = intent.getStringExtra("firstName")
        val lastname = intent.getStringExtra("lastName")
        val middleInitial = intent.getStringExtra("middleInitial")
        val gender = intent.getStringExtra("gender")
        val bmi = intent.getFloatExtra("bmi", 0.0f) // Extract BMI as a float, defaulting to 0.0f if not found

        val fullName = "$firstname $middleInitial $lastname"
        val formattedName = fullName.split(" ").joinToString(" ") { it.capitalize() }

        binding.genderTxt.text = gender
        binding.nameTxt.text = formattedName
        binding.bmiTxt.text = String.format("%.2f", bmi)

        val bmiStatus: String = when {
            bmi < 18.5 -> {
                binding.bmiTagTxt.setTextColor(Color.RED) // Change color to red
                binding.underweightTxt.setBackgroundColor(Color.RED)
                "Underweight"
            }
            bmi < 25 -> {
                binding.bmiTagTxt.setTextColor(Color.GREEN) // Change color to green
                binding.hlthyWeightTxt.setBackgroundColor(Color.GREEN)
                "Healthy Weight"
            }
            bmi < 30 -> {
                binding.bmiTagTxt.setTextColor(Color.RED) // Change color to red
                binding.overweightTxt.setBackgroundColor(Color.RED)
                "Overweight"
            }
            else -> {
                binding.bmiTagTxt.setTextColor(Color.RED) // Change color to red
                binding.obeseTxt.setBackgroundColor(Color.RED)
                "Obese"
            }


        }
        binding.bmiTagTxt.text = bmiStatus
        binding.goBackBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}