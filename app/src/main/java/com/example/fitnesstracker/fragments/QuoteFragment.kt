package com.example.fitnesstracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.fitnesstracker.R
import com.example.fitnesstracker.helpers.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuoteFragment : Fragment() {

    private lateinit var textQuote: TextView
    private lateinit var buttonRefresh: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_quote, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textQuote = view.findViewById(R.id.textQuote)
        buttonRefresh = view.findViewById(R.id.buttonNewQuote)

        buttonRefresh.setOnClickListener {
            loadRandomQuote()
        }

        loadRandomQuote() // Load once on start
    }

    private fun loadRandomQuote() {
        lifecycleScope.launch {
            try {
                val quotes = withContext(Dispatchers.IO) {
                    RetrofitClient.quoteService.getQuotes()
                }
                val random = quotes.random()
                textQuote.text = "\"${random.text}\" — ${random.author ?: "Unknown"}"
            } catch (e: Exception) {
                textQuote.text = "Failed to load quote. Try again."
            }
        }
    }
}
