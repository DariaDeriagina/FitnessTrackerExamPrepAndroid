package com.example.fitnesstracker.helpers

import com.example.fitnesstracker.models.Quote
import retrofit2.http.GET

interface QuoteApiService {
    @GET("quotes")
    suspend fun getQuotes(): List<Quote>
}
