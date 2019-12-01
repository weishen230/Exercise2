package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   lateinit var total :TextView
    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        total = findViewById(R.id.textViewBMI)
        image = findViewById(R.id.imageViewProfile)



        buttonCalculate.setOnClickListener{view : View ->

            val weight = editTextWeight.text.toString().toDouble()
            val height = editTextHeight.text.toString().toDouble()
            val heightInMeter =  height/100

            val bmi = weight / (heightInMeter*heightInMeter)

            total.setText("BMI: " + "%.2f".format(bmi).toDouble())

            if(bmi < 18.5)
            {
                image.setImageResource(R.drawable.under)
            }
            else if(bmi < 25 && bmi >= 18.5)
            {
                image.setImageResource(R.drawable.normal)
            }
            else if(bmi >= 25)
            {
                image.setImageResource(R.drawable.over)
            }

        }


        buttonReset.setOnClickListener{view : View ->

            editTextHeight.setText("")
            editTextWeight.setText("")

            imageViewProfile.setImageResource(R.drawable.empty)
            textViewBMI.setText("BMI: ")

        }

    }
}
