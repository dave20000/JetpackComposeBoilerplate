package com.example.notz.domain.states

import com.example.notz.domain.models.Note
import java.lang.Exception

sealed class NotesState {
    data object Initial : NotesState()
    data object Loading : NotesState()
    data class Loaded(val notes: List<Note>) : NotesState()
    data class Error(val exception: Exception) : NotesState()
}


