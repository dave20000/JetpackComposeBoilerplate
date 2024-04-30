package com.example.notz.domain.usecases.notes

import com.example.notz.domain.models.Note
import com.example.notz.domain.repositories.NotesRepository
import com.example.notz.domain.states.DataState
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {
    suspend operator fun invoke(note: Note) : DataState<Boolean> {
        return notesRepository.updateNote(note)
    }
}