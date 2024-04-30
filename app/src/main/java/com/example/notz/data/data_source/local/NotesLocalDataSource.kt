package com.example.notz.data.data_source.local

import com.example.notz.data.data_source.local.dao.AppDatabase
import com.example.notz.data.models.cache_dto.NoteCacheDto
import javax.inject.Inject

class NotesLocalDataSource @Inject constructor(
    private val appDatabase: AppDatabase,
){
    suspend fun getNotes(): List<NoteCacheDto> {
        val notes =  appDatabase.noteDao.getNotes()
        println("Log: $notes")
        return notes
    }

    suspend fun insertNote(noteCacheDto: NoteCacheDto) {
        appDatabase.noteDao.insertNote(noteCacheDto)
    }

    suspend fun deleteNote(noteCacheDto: NoteCacheDto) {
        appDatabase.noteDao.deleteNote(noteCacheDto)
    }

    suspend fun updateNote(noteCacheDto: NoteCacheDto) {
        appDatabase.noteDao.updateNote(noteCacheDto)
    }
}
