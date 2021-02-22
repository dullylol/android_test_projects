package com.asustuf.firstdb.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "userDB"
        const val TABLE_USERS = "users"

        const val KEY_ID = "_id"
        const val KEY_EMAIL = "email"
        const val KEY_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table $TABLE_USERS(" +
                "$KEY_ID integer primary key," +
                "$KEY_EMAIL text," +
                "$KEY_PASSWORD text)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists $TABLE_USERS")
        onCreate(db)
    }
}