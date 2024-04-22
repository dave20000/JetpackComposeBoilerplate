package com.example.notz.data.data_source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object {
        private const val baseUrl = "https://newsapi.org/v2/"

        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Companion.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val newsApiService: NewsApiService by lazy {
            retrofit.create(NewsApiService::class.java)
        }
    }

}