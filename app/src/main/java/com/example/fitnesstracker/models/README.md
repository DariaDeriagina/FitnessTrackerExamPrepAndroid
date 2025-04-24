# Fitness Tracker App

A simple Android app to track daily workout sessions. Users can add sessions, view past sessions, and get daily motivational reminders.

---

## project:
name: "Fitness Tracker App"
description: >
An Android app that tracks daily workout sessions. Users can add sessions,
view a list, receive daily motivational notifications, load quotes from an API,
and handle background events like battery low or timers.

steps:
- step: "Create New Android Project"
  instructions:
    - Open Android Studio → New Project
    - Choose "Empty Activity"
    - Set language to Kotlin
    - Set min API level to 21 or higher
    - Name it "FitnessTracker"

- step: "Create Folder Structure"
  folders:
    - models
    - fragments
    - adapters
    - helpers
    - receivers
    - services
    - workmanager
      location: "java/com.example.fitnesstracker"

- step: "Create Data Model"
  file: "models/Session.kt"
  explanation: >
  This file defines the Session data class used for each workout session.
  It contains fields for date, workout type, and duration.

- step: "Create Layout XML Files"
  files:
    - fragment_add_session.xml
    - fragment_session_list.xml
    - item_session.xml
    - fragment_quote.xml (optional)
      location: "res/layout"
      explanation: >
      These layouts are used in the fragments for user input, viewing lists, and quote display.

- step: "Create RecyclerView Adapter"
  file: "adapters/SessionAdapter.kt"
  explanation: >
  This adapter binds session data to the RecyclerView using ListAdapter and DiffUtil for performance.

- step: "Create Fragments"
  files:
    - fragments/SessionListFragment.kt
    - fragments/AddSessionFragment.kt
      explanation: >
      SessionListFragment displays the list of saved sessions.
      AddSessionFragment allows users to input and save new sessions.

- step: "Setup Navigation"
  files:
    - res/navigation/nav_graph.xml
    - activity_main.xml
      explanation: >
      Use Navigation Component to switch between fragments.
      Add actions and link your NavHostFragment in activity_main.xml.

- step: "Create File Helper"
  file: "helpers/SessionFileHelper.kt"
  explanation: >
  This helper reads and writes a list of sessions to a local JSON file using internal storage and Gson.

- step: "Connect Save and Load Logic"
  explanation: >
  Use SessionFileHelper in AddSessionFragment to save data, and in SessionListFragment to load and show it.

- step: "Add Motivational Quotes (Optional)"
  files:
    - models/Quote.kt
    - helpers/QuoteApiService.kt
    - helpers/RetrofitClient.kt
    - fragments/QuoteFragment.kt
      explanation: >
      Load quotes from the internet using Retrofit and show a random quote with a refresh button.

- step: "Add WorkManager for Daily Reminder"
  file: "workmanager/ReminderWorker.kt"
  explanation: >
  Schedule a daily notification using WorkManager that reminds the user to log their workout.

- step: "Add BroadcastReceiver"
  file: "receivers/BatteryReceiver.kt"
  explanation: >
  Show a Toast message when the battery is low. Register it in AndroidManifest.xml.

- step: "Add Foreground Service"
  file: "services/HabitTimerService.kt"
  explanation: >
  Show a permanent notification to simulate a habit timer session. Start this service from a button.

- step: "Finalize MainActivity"
  file: "MainActivity.kt"
  explanation: >
  Set up edge-to-edge layout, NavHostFragment, WorkManager, and window insets (if needed).

tools:
- Kotlin
- Android Navigation Component
- RecyclerView + DiffUtil
- Internal File I/O
- Gson
- WorkManager
- BroadcastReceiver
- Retrofit2
- Coroutines
- ForegroundService


