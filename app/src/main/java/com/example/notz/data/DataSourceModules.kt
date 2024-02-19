package com.example.notz.data

import com.example.notz.data.data_source.NotesRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModules {
    @Provides
    fun providesNotesRemoteDataSource(): NotesRemoteDataSource =
         NotesRemoteDataSource()
}