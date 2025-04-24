package com.example.fitnesstracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.R
import com.example.fitnesstracker.Session
import com.example.fitnesstracker.adapters.SessionAdapter
import com.example.fitnesstracker.models.Session

class SessionListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SessionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_session_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recyclerViewSessions)
        adapter = SessionAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Dummy session list for now (replace with real data later)
        val sessions = listOf(
            Session("2025-04-23", "Yoga", "30 mins"),
            Session("2025-04-22", "Cardio", "45 mins")
        )
        adapter.submitList(sessions)
    }
}

//https://developer.android.com/guide/navigation
//https://developer.android.com/guide/fragments/lifecycle