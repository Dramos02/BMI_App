package com.example.bmi_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi_app.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedGender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.maleRadBtn.setOnClickListener {
            if (binding.maleRadBtn.isChecked) {
                selectedGender = "Mr"
                binding.femaleRadBtn.isChecked = false

            } else {
                binding.maleRadBtn.isChecked = true
            }
        }

        binding.femaleRadBtn.setOnClickListener {
            if (binding.femaleRadBtn.isChecked) {
                selectedGender = "Ms"
                binding.maleRadBtn.isChecked = false
            } else {
                binding.femaleRadBtn.isChecked = true
            }
        }

        binding.resultBtn.setOnClickListener {

            val firstName = binding.FnameTxt.text.toString()
            val lastName = binding.LnameTxt.text.toString()
            val middleInitial = binding.InitialTxt.text.toString()
            val heightStr = binding.heightInt.text.toString()
            val weightStr = binding.weightInt.text.toString()



            if (firstName.isNotEmpty() && lastName.isNotEmpty() && middleInitial.isNotEmpty() &&
                heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height = heightStr.toFloat()
                val weight = weightStr.toFloat()

                if (selectedGender == null) {
                    Toast.makeText(applicationContext, "Please select a gender", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener // Exit the click action
                }
                val bmi = calcBMI(height, weight)

                var intent = Intent(this, BMIOutputScreen::class.java)
                intent.putExtra("firstName", firstName)
                intent.putExtra("lastName", lastName)
                intent.putExtra("middleInitial", middleInitial)
                intent.putExtra("gender", selectedGender)
                intent.putExtra("bmi", bmi)
                startActivity(intent)
                this.finish()
            } else {
                Toast.makeText(applicationContext, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calcBMI(height: Float, weight: Float): Float {

        val heightInMeters = height / 100 // Convert height from cm to meters
        return if (heightInMeters > 0) {
            weight / (heightInMeters * heightInMeters)
        } else {
            0.0f
        }
    }
}


