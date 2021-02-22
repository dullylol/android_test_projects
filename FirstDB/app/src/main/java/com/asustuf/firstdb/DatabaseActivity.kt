package com.asustuf.firstdb

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.asustuf.firstdb.DB.DBHelper

class DatabaseActivity : AppCompatActivity() {
    lateinit var emailTextView: EditText
    lateinit var passwordTextView: EditText

    lateinit var dbHelper: DBHelper
    lateinit var database: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        emailTextView = findViewById(R.id.emailAddress)
        passwordTextView = findViewById(R.id.password)

        //database
        dbHelper = DBHelper(this)
        database = dbHelper.writableDatabase

        findViewById<Button>(R.id.addToDBButton).setOnClickListener {
            val email = emailTextView.text.toString()
            val password = passwordTextView.text.toString()

            val contentValues = ContentValues()

            contentValues.put(DBHelper.KEY_EMAIL, email)
            contentValues.put(DBHelper.KEY_PASSWORD, password)

            database.insert(DBHelper.TABLE_USERS, null, contentValues)

            emailTextView.setText("")
            passwordTextView.setText("")
        }
        findViewById<Button>(R.id.loadFromDBButton).setOnClickListener {
            val cursor: Cursor = database.query(DBHelper.TABLE_USERS,
                    null, null, null,
                    null, null, null
            )

            if (cursor.moveToFirst()) {
                var idIndex = cursor.getColumnIndex(DBHelper.KEY_ID)
                var emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL)
                var passwordIndex = cursor.getColumnIndex(DBHelper.KEY_PASSWORD)

                do {
                    Log.d("mLog", "ID: ${cursor.getInt(idIndex)}," +
                            " name: ${cursor.getString(emailIndex)}," +
                            " email: ${cursor.getString(passwordIndex)}")
                } while (cursor.moveToNext())
            }
            else {
                Log.d("mLog", "0 rows")
            }
        }
        findViewById<Button>(R.id.clearDBButton).setOnClickListener {
            database.delete(DBHelper.TABLE_USERS, null, null)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }


}