package com.example.notz.domain.usecases.notes

import com.example.notz.domain.models.Note
import com.example.notz.domain.repositories.NotesRepository
import com.example.notz.domain.states.DataState
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {
    suspend operator fun invoke(): DataState<List<Note>> {
        return notesRepository.getNotes()
    }
}