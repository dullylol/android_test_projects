package com.asustuf.testviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.asustuf.testviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.oneText = "One"
        binding.twoText = "two"
        binding.threeText = "Three"

        binding.oneTextView.setTextColor(resources.getColor(R.color.black))


    }
}