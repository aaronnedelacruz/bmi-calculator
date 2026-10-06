package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.bmicalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCompute.setOnClickListener(){
            val intent = Intent(this,MainActivity2::class.java)
            val firstName = binding.edtFirstName.text.toString()
            val midInit = binding.edtMidInit.text.toString()
            val lastName = binding.edtLastName.text.toString()
            var gender = ""

            val checkedId = binding.rgroupGender.checkedRadioButtonId
            if (checkedId != -1) {
                val selectedRadBtn = findViewById<RadioButton>(checkedId)
                gender = selectedRadBtn.text.toString()
            }

            val heightText = binding.edtHeight.text.toString()
            val weightText = binding.edtWeight.text.toString()

            val height = heightText.toDoubleOrNull() ?: 0.0
            val weight = weightText.toDoubleOrNull() ?: 0.0

            if(firstName.isEmpty() || midInit.isEmpty() ||lastName.isEmpty() ||gender.isEmpty() || heightText.isEmpty() || weightText.isEmpty()){
                Toast.makeText(applicationContext, "Please complete all required information.", Toast.LENGTH_SHORT).show()
            }
            else{
                val fullName = "$firstName $midInit $lastName"
                val heightMeter = height/100
                val bmi = weight / (heightMeter * heightMeter)

                intent.putExtra("genderData", gender)
                intent.putExtra("fullNameData", fullName)
                intent.putExtra("bmiData", bmi)
                startActivity(intent)
            }
        }
    }
}