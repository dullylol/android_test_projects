package com.asustuf.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonDivide: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonPow: Button
    private lateinit var buttonClean: Button

    private lateinit var number1: TextView
    private lateinit var operation: TextView
    private lateinit var number2: TextView
    private lateinit var result: TextView

    private lateinit var imageSamurai: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Buttons initialization
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonPow = findViewById(R.id.buttonPow)
        buttonClean = findViewById(R.id.buttonClean)

        //TextView initialization
        number1 = findViewById(R.id.number1)
        operation = findViewById(R.id.operation)
        number2 = findViewById(R.id.number2)
        result = findViewById(R.id.result)

        //ImageView initialization
        imageSamurai = findViewById(R.id.imageSamurai)

        imageSamurai.visibility = View.VISIBLE
    }

    public fun onClickButton(v: View) {
        var num1: Float
        var num2: Float

        try {
            num1 = number1.text.toString().toFloat()
            num2 = number2.text.toString().toFloat()
        } catch (e: NumberFormatException) {
            return
        }

        when (v.id) {
            R.id.buttonAdd -> {
                operation.text = "+"
                result.text = (num1 + num2).toString()
            }
            R.id.buttonSubtract -> {
                operation.text = "-"
                result.text = (num1 - num2).toString()
            }
            R.id.buttonMultiply -> {
                operation.text = "*"
                result.text = (num1 * num2).toString()
            }
            R.id.buttonDivide -> {
                operation.text = "/"
                result.text = (num1 / num2).toString()
            }
            R.id.buttonPow -> {
                operation.text = "^"
                result.text = (pow(num1.toDouble(), num2.toDouble())).toString()
            }
            R.id.buttonClean -> {
                operation.text = ""
                result.text = ""
                number1.text = ""
                number2.text = ""
            }
        }

    }


}