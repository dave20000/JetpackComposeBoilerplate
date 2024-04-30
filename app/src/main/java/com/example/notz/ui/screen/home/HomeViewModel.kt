package com.example.notz.ui.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notz.domain.models.Note
import com.example.notz.domain.states.DataState
import com.example.notz.domain.states.NotesState
import com.example.notz.domain.usecases.notes.DeleteNoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
//import androidx.lifecycle.viewModelScope
import com.example.notz.domain.usecases.notes.GetNotesUseCase
import com.example.notz.domain.usecases.notes.InsertNoteUseCase
import com.example.notz.domain.usecases.notes.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val insertNoteUseCase: InsertNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<NotesState>(NotesState.Initial)
    val state: StateFlow<NotesState> = _state.asStateFlow()

    init {
        Log.e("HomeViewModelInit", "Khi Khi")
        getNotes()
    }

    private fun getNotes() {
        _state.update { NotesState.Loading }
        viewModelScope.launch {
            when (val notesDataState = getNotesUseCase()) {
                is DataState.Success -> _state.update { NotesState.Loaded(notes = notesDataState.data) }
                is DataState.Error -> _state.update { NotesState.Error(exception = notesDataState.exception) }
            }
        }
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            when (val notesDataState = insertNoteUseCase(note = note)) {
                is DataState.Success -> getNotes()
                is DataState.Error -> TODO()
            }
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            when (val notesDataState = updateNoteUseCase(note = note)) {
                is DataState.Success -> getNotes()
                is DataState.Error -> TODO()
            }
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            when (val notesDataState = deleteNoteUseCase(note = note)) {
                is DataState.Success -> getNotes()
                is DataState.Error -> TODO()
            }
        }
    }
}

//val homeViewModelObject = HomeViewModel(
//    getNotesUseCase = GetNotesUseCase(
//        notesRepository = NotesRepositoryImpl(
//            ioDispatcher = Dispatchers.IO,
//            notesRemoteDataSource = NotesRemoteDataSource()
//        )
//    )
//)