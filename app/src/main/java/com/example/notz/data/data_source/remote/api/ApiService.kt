package com.example.notz.data.data_source.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object {
        private const val baseUrl = "https://newsapi.org/v2/"

        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val newsApiService: NewsApiService by lazy {
            retrofit.create(NewsApiService::class.java)
        }
    }

}