package com.asustuf.dialog

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val mIngredients = arrayOf("Курица", "Сок", "Картошка", "Помидоры")
    val mSelectedIngredients = arrayOf(false, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCloseButtonClick(view: View) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Выход из приложения")
                .setIcon(R.drawable.close_button)
                .setMessage("Вы уверены, что хотите выйти?")
                .setCancelable(false)
                .setPositiveButton("OK") { dialog, id -> finish()
                }
                .setNegativeButton("Отмена") { dialog, id ->  dialog.cancel()
                }

        val alert = builder.create()
        alert.show()

    }

    fun onChooseButtonClick(view: View) {
        var builder = AlertDialog.Builder(this)


        builder.setTitle("Выберите ингридиенты для ужина")
                .setIcon(R.drawable.ok_button)
                .setCancelable(false)
                .setMultiChoiceItems(mIngredients, mSelectedIngredients.toBooleanArray()) {
                    dialog, which, isChecked -> mSelectedIngredients[which] = isChecked
                }
                .setPositiveButton("OK") { dialog, id ->  dialog.cancel()
                }
                .setNegativeButton("Отмена") { dialog, id ->  dialog.cancel()
                }


        var alert = builder.create()
        alert.show()

    }
}

