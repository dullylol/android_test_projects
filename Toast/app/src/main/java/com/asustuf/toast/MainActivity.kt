package com.asustuf.toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(v: View) {

        var myToast :Toast = when (v.id) {
            R.id.imageButtonCat1 -> {
                Toast.makeText(applicationContext, "Левый котик", Toast.LENGTH_SHORT)
            }
            R.id.imageButtonCat2 -> {
                Toast.makeText(applicationContext, "Центральный котик", Toast.LENGTH_SHORT)
            }
            R.id.imageButtonCat3 -> {
                Toast.makeText(applicationContext, "Правый котик", Toast.LENGTH_SHORT)
            }
            else -> {
                Toast.makeText(applicationContext, "Без котиков", Toast.LENGTH_SHORT)
            }
        }
        myToast.show()
    }
}