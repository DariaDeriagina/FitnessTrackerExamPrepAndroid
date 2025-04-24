package com.example.fitnesstracker.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "⚠️ Sync paused due to low battery", Toast.LENGTH_SHORT).show()
    }
}
