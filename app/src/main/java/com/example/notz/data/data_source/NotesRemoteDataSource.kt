package com.example.notz.data.data_source

import com.example.notz.core.notes
import com.example.notz.data.models.NoteApiDto

class NotesRemoteDataSource {
    private val newsApiService = ApiService.newsApiService

    suspend fun getNotes(): List<NoteApiDto> {
        val news =  newsApiService.getNewsByCategory(category = null)
        println("Log: $news")
        return notes
    }
}