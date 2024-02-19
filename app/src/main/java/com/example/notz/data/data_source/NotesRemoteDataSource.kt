package com.example.notz.data.data_source

import com.example.notz.core.notes
import com.example.notz.data.models.NoteApiDto
import com.example.notz.domain.models.Note
import com.example.notz.domain.models.NoteTag
import kotlinx.coroutines.delay

class NotesRemoteDataSource {
    suspend fun getNotes(): List<NoteApiDto> {
        delay(5000L)
        return notes
    }
}