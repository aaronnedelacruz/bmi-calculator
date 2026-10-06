package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val passedGender = intent.getStringExtra("genderData")
        if (passedGender == "Male") {
            binding.txtGender.text = "MR."
        } else {
            binding.txtGender.text = "MS."
        }

        val passedFullName = intent.getStringExtra("fullNameData")
        binding.txtFullName.text = "$passedFullName"

        val passedBMI = intent.getDoubleExtra("bmiData", 0.0)
        val formattedBMI = "%.2f".format(passedBMI).toDouble()
        binding.txtBMIResult.text = formattedBMI.toString()

        if (formattedBMI < 18.5) {
            binding.txtFinding1.setBackgroundColor(Color.RED)
            binding.txtBMIFinding.text = "UNDERWEIGHT"
            binding.txtBMIFinding.setTextColor(android.graphics.Color.RED)
        }
        if (formattedBMI >= 18.5 && formattedBMI < 25) {
            binding.txtFinding2.setBackgroundColor(Color.GREEN)
            binding.txtBMIFinding.text = "HEALTHY WEIGHT"
            binding.txtBMIFinding.setTextColor(android.graphics.Color.GREEN)
        }
        if (formattedBMI >= 25 && formattedBMI < 30) {
            binding.txtFinding3.setBackgroundColor(Color.RED)
            binding.txtBMIFinding.text = "OVERWEIGHT"
            binding.txtBMIFinding.setTextColor(android.graphics.Color.RED)

        }
        if (formattedBMI >= 30) {
            binding.txtFinding4.setBackgroundColor(Color.RED)
            binding.txtBMIFinding.text = "OBSESE"
            binding.txtBMIFinding.setTextColor(android.graphics.Color.RED)

        }
    }
}
