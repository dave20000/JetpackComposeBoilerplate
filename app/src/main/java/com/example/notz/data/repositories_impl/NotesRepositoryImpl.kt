package com.example.notz.data.repositories_impl

import com.example.notz.data.data_source.local.NotesLocalDataSource
import com.example.notz.data.data_source.remote.NotesRemoteDataSource
import com.example.notz.data.models.cache_dto.toModel
import com.example.notz.domain.models.Note
import com.example.notz.domain.models.toCacheDto
import com.example.notz.domain.repositories.NotesRepository
import com.example.notz.domain.states.DataState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val notesRemoteDataSource: NotesRemoteDataSource,
    private val notesLocalDataSource: NotesLocalDataSource,
) : NotesRepository {
    override suspend fun getNotes(): DataState<List<Note>> {
        return withContext(ioDispatcher) {
//            DataState.Success(notesRemoteDataSource.getNotes().map { it.toModel() })
            DataState.Success(notesLocalDataSource.getNotes().map { it.toModel() })
        }
    }

    override suspend fun insertNote(note: Note): DataState<Boolean> {
        return withContext(ioDispatcher){
            notesLocalDataSource.insertNote(note.toCacheDto())
            DataState.Success(true)
        }
    }

    override suspend fun deleteNote(note: Note): DataState<Boolean> {
        return withContext(ioDispatcher){
            notesLocalDataSource.deleteNote(note.toCacheDto())
            DataState.Success(true)
        }
    }

    override suspend fun updateNote(note: Note): DataState<Boolean> {
        return withContext(ioDispatcher){
            notesLocalDataSource.updateNote(note.toCacheDto())
            DataState.Success(true)
        }
    }
}