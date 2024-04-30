package com.example.notz.data.models.api_dto

import com.example.notz.domain.models.Note
import com.example.notz.domain.models.NoteTag

data class NoteApiDto(
    val id: Long,
    val title: String,
    val description: String,
    val createdAt: String,
    val lastEditedAt: String,
    val noteTag: NoteTag
)

fun NoteApiDto.toModel(): Note = Note(
    id= id,
    title = title,
    description = description,
    createdAt = createdAt,
    lastEditedAt = lastEditedAt,
    noteTag = noteTag,
)