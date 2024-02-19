package com.example.notz.ui.screen.home

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notz.data.data_source.NotesRemoteDataSource
import com.example.notz.data.repositories_impl.NotesRepositoryImpl
import com.example.notz.domain.models.Note
import com.example.notz.domain.models.NoteTag
import com.example.notz.domain.states.DataState
import com.example.notz.domain.states.NotesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
//import androidx.lifecycle.viewModelScope
import com.example.notz.domain.usecases.notes.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<NotesState>(NotesState.Initial)
    val state: StateFlow<NotesState> = _state.asStateFlow();

    init {
        Log.e("HomeViewModelInit", "Khi Khi")
        getNotes()
    }

    fun getNotes() {
        _state.update { NotesState.Loading }
        viewModelScope.launch {
            when (val notesDataState = getNotesUseCase()) {
                is DataState.Success -> _state.update { NotesState.Loaded(notes = notesDataState.data) }
                is DataState.Error -> _state.update { NotesState.Error(exception = notesDataState.exception) }
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