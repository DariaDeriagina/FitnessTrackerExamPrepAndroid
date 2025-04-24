package com.example.fitnesstracker.helpers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val quoteService: QuoteApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://type.fit/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApiService::class.java)
    }
}
