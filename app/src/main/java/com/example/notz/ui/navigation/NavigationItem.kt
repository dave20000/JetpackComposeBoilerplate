package com.example.notz.ui.navigation

sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem("home")
    data object NoteDetail : NavigationItem("note_detail/{noteIndex}"){
        fun passNoteIndex(noteIndex: Int) = "note_detail/${noteIndex}"
    }
}