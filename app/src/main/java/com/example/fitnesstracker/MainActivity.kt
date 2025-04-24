package com.example.fitnesstracker

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.fitnesstracker.workmanager.ReminderWorker
import java.util.concurrent.TimeUnit
import androidx.work.PeriodicWorkRequestBuilder



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply insets to nav_host_fragment instead of 'main'
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nav_host_fragment)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up daily WorkManager task
        val workRequest = PeriodicWorkRequestBuilder<ReminderWorker>(1, TimeUnit.DAYS).build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }
}
