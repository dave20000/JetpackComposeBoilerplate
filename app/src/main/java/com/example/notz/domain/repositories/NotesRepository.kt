package com.example.notz.domain.repositories

import com.example.notz.domain.models.Note
import com.example.notz.domain.states.DataState

interface NotesRepository {
    suspend fun getNotes(): DataState<List<Note>>
}