package com.example.fitnesstracker.helpers

import android.content.Context
import com.example.fitnesstracker.models.Session
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SessionFileHelper {
    private const val FILE_NAME = "sessions.json"

    fun saveSessions(context: Context, sessionList: List<Session>) {
        val json = Gson().toJson(sessionList)
        context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use {
            it.write(json.toByteArray())
        }
    }

    fun loadSessions(context: Context): List<Session> {
        return try {
            val json = context.openFileInput(FILE_NAME).bufferedReader().readText()
            val type = object : TypeToken<List<Session>>() {}.type
            Gson().fromJson(json, type)
        } catch (e: Exception) {
            emptyList()
        }
    }
}


//https://developer.android.com/training/data-storage/app-specific#internal-storage
//https://github.com/google/gson