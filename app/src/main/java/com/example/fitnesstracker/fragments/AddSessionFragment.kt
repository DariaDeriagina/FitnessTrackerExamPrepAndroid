package com.example.fitnesstracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnesstracker.R
import com.example.fitnesstracker.models.Session
import com.example.fitnesstracker.helpers.SessionFileHelper




class AddSessionFragment : Fragment() {

    private lateinit var editDate: EditText
    private lateinit var editWorkout: EditText
    private lateinit var editDuration: EditText
    private lateinit var buttonSave: Button

    // Inflate layout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_session, container, false)
    }

    // Setup logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        editDate = view.findViewById(R.id.editTextDate)
        editWorkout = view.findViewById(R.id.editTextWorkout)
        editDuration = view.findViewById(R.id.editTextDuration)
        buttonSave = view.findViewById(R.id.buttonSaveSession)

        buttonSave.setOnClickListener {
            val date = editDate.text.toString()
            val workout = editWorkout.text.toString()
            val duration = editDuration.text.toString()

            val newSession = Session(date, workout, duration)

            // inside buttonSave.setOnClickListener:
            val context = requireContext()
            val sessions = SessionFileHelper.loadSessions(context).toMutableList()
            sessions.add(newSession)
            SessionFileHelper.saveSessions(context, sessions)


            // Save this data using file or shared ViewModel later

            // Navigate to the list
            findNavController().navigate(R.id.action_addSessionFragment_to_sessionListFragment)
        }
    }
}
