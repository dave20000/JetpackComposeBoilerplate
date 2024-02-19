package com.example.notz.domain

import com.example.notz.domain.repositories.NotesRepository
import com.example.notz.domain.usecases.notes.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModules {
    @Provides
    fun providesGetNotesUseCase(
        notesRepository: NotesRepository
    ) : GetNotesUseCase = GetNotesUseCase(notesRepository)
}