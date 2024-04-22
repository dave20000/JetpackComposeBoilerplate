package com.example.notz.data.data_source

import com.example.notz.data.models.NewsApiDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getNewsByCategory(
        @Query("country") country: String = "in",
        @Query("apiKey") apiKey: String = "79cfebf25f2b48cf8dcb266bebfada88",
        @Query("category") category: String?,
    ) : NewsApiDto
}