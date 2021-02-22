package com.asustuf.notifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var notificationManager: NotificationManagerCompat
    private lateinit var editTextTitle: EditText
    private lateinit var editTextMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)
        editTextTitle = findViewById(R.id.edit_text_title)
        editTextMessage = findViewById(R.id.edit_text_message)
    }

    fun sendOnChannel1(view: View) {
        val notification = NotificationCompat.Builder(this, App.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.small_bell)
                .setContentTitle(editTextTitle.text)
                .setContentText(editTextMessage.text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build()

        notificationManager.notify(1, notification)
    }

    fun sendOnChannel2(view: View) {
        val notification = NotificationCompat.Builder(this, App.CHANNEL_ID_2)
                .setSmallIcon(R.drawable.small_bell)
                .setContentTitle(editTextTitle.text)
                .setContentText(editTextMessage.text)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build()

        notificationManager.notify(2, notification)
    }

//    fun onClickBellButton(view: View) {
//        /*val openMainActivityIntent = Intent(this, MainActivity.javaClass)
//
//        val stackBuilder = TaskStackBuilder.create(this)
//            .addParentStack(MainActivity.javaClass)
//            .addNextIntent(openMainActivityIntent)
//
//        val resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
//
//        val notificationBuilder = NotificationCompat.Builder(this)
//            .setSmallIcon(R.drawable.small_bell)
//            .setContentTitle("Bell")
//            .setContentText("Wake up, Neo...\n Follow the white rabbit!")
//            .setContentIntent(resultPendingIntent)
//
//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())*/
//        val intent = Intent(this, MainActivity.javaClass).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
//
//        val builder = NotificationCompat.Builder(this, "i.apps.notifications")
//                .setSmallIcon(R.drawable.small_bell)
//                .setContentTitle("My notification")
//                .setContentText("Hello World!")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true)
//
//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        notificationManager.notify(NOTIFICATION_ID, builder.build())
//
//    }
}