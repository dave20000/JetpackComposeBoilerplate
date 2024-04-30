package com.example.notz.domain.models

import androidx.compose.ui.graphics.Color
import com.example.notz.data.models.cache_dto.NoteCacheDto

data class Note(
    val id: Long?,
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

fun Note.toCacheDto(): NoteCacheDto = NoteCacheDto(
    id =  id ?: 0,
    title = title,
    description = description,
    createdAt = createdAt,
    lastEditedAt = lastEditedAt,
    noteTag = noteTag,
)