package com.asustuf.testviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.asustuf.testviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.firstButton.setOnClickListener() {
            Toast.makeText(this,
                    "You clicked on first button!",
                    Toast.LENGTH_SHORT)
                    .show()

            binding.textView.text = "First button"
        }

        binding.secondButton.setOnClickListener() {
            Toast.makeText(this,
                    "You clicked on second button!",
                    Toast.LENGTH_SHORT)
                    .show()

            binding.textView.text = "Second button"
        }

        binding.thirdButton.setOnClickListener() {
            Toast.makeText(this,
                    "You clicked on third button!",
                    Toast.LENGTH_SHORT)
                    .show()

            binding.textView.text = "Third button"
        }
    }
}