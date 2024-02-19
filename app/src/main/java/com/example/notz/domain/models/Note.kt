package com.example.notz.domain.models

import androidx.compose.ui.graphics.Color
class Note(
    val title: String,
    val description: String,
    val createdAt: String,
    val lastEditedAt: String,
    val noteTag: NoteTag
)

enum class NoteTag(val color: Color) {
    Journal(Color.Magenta),
    Work(Color.Blue),
    Ideas(Color.Green),
    ToDo(Color.Yellow)
}

