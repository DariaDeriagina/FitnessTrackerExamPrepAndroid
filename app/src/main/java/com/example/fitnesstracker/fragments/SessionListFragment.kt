package com.example.fitnesstracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.R
import com.example.fitnesstracker.adapters.SessionAdapter
import com.example.fitnesstracker.helpers.SessionFileHelper

class SessionListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SessionAdapter
    private lateinit var buttonAdd: Button  // ← Declare the button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_session_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 🟢 FIND UI ELEMENTS
        recyclerView = view.findViewById(R.id.recyclerViewSessions)
        buttonAdd = view.findViewById(R.id.buttonAddSession)

        // 🟢 SETUP RECYCLER VIEW
        adapter = SessionAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // 🟢 LOAD SESSION DATA FROM FILE
        val sessions = SessionFileHelper.loadSessions(requireContext())
        adapter.submitList(sessions)

        // 🟢 HANDLE BUTTON CLICK → Navigate to AddSessionFragment
        buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_sessionListFragment_to_addSessionFragment)
        }
    }
}
