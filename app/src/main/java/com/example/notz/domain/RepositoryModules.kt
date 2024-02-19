package com.example.notz.domain

import com.example.notz.data.data_source.NotesRemoteDataSource
import com.example.notz.data.repositories_impl.NotesRepositoryImpl
import com.example.notz.domain.repositories.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModules {

    @Provides
    fun providesNotesRepository(
        notesRemoteDataSource: NotesRemoteDataSource
    ): NotesRepository = NotesRepositoryImpl(
        ioDispatcher = Dispatchers.IO,
        notesRemoteDataSource = notesRemoteDataSource,
    )
}