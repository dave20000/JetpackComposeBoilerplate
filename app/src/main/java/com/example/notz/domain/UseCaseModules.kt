package com.example.notz.domain

import com.example.notz.domain.repositories.NotesRepository
import com.example.notz.domain.usecases.notes.DeleteNoteUseCase
import com.example.notz.domain.usecases.notes.GetNotesUseCase
import com.example.notz.domain.usecases.notes.InsertNoteUseCase
import com.example.notz.domain.usecases.notes.UpdateNoteUseCase
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

    @Provides
    fun providesInsertNotesUseCase(
        notesRepository: NotesRepository
    ) : InsertNoteUseCase = InsertNoteUseCase(notesRepository)

    @Provides
    fun providesDeleteNotesUseCase(
        notesRepository: NotesRepository
    ) : DeleteNoteUseCase = DeleteNoteUseCase(notesRepository)

    @Provides
    fun providesUpdateNotesUseCase(
        notesRepository: NotesRepository
    ) : UpdateNoteUseCase = UpdateNoteUseCase(notesRepository)
}