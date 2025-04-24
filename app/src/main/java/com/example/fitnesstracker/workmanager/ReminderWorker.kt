package com.example.fitnesstracker.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.fitnesstracker.R

class ReminderWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        showReminder()
        return Result.success()
    }

    private fun showReminder() {
        val channelId = "habit_channel"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Habit Reminder", NotificationManager.IMPORTANCE_DEFAULT)
            val manager = applicationContext.getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle("Fitness Tracker")
            .setContentText("Don't forget to log your workout today! 💪")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        NotificationManagerCompat.from(applicationContext).notify(1, notification)
    }
}
