package com.example.notz.domain.repositories

import com.example.notz.domain.models.Note
import com.example.notz.domain.states.DataState

interface NotesRepository {
    suspend fun getNotes(): DataState<List<Note>>
    suspend fun insertNote(note: Note) : DataState<Boolean>
    suspend fun deleteNote(note: Note): DataState<Boolean>
    suspend fun updateNote(note: Note): DataState<Boolean>
}