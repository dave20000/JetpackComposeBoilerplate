package com.example.notz.data.repositories_impl

import com.example.notz.data.data_source.NotesRemoteDataSource
import com.example.notz.data.models.toModel
import com.example.notz.domain.models.Note
import com.example.notz.domain.repositories.NotesRepository
import com.example.notz.domain.states.DataState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val notesRemoteDataSource: NotesRemoteDataSource
) : NotesRepository {
    override suspend fun getNotes(): DataState<List<Note>> {
        return withContext(ioDispatcher) {
            DataState.Success(notesRemoteDataSource.getNotes().map { it.toModel() })
        }
    }
}