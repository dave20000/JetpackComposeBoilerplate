package com.example.notz.ui.navigation

sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem("home")
    data object NoteAddEdit: NavigationItem("note_add_edit"){
        const val EDIT_ROUTE = "note_add_edit/{noteIndex}"
        fun passNoteIndex(noteIndex: Int) = "note_add_edit/${noteIndex}"
    }
}