package com.example.notz.core

import com.example.notz.data.models.NoteApiDto
import com.example.notz.domain.models.NoteTag

val notes = listOf<NoteApiDto>(
    NoteApiDto(
        title = "New Idea",
        description = "This is my new idea that works well",
        createdAt = "8 Jan 2024",
        lastEditedAt = "16 Feb 2024",
        noteTag = NoteTag.Ideas,
    ),
    NoteApiDto(
        title = "News Modi",
        description = "PM Modi goes to maldives asdnkjsadn aksda shdkajsh daasd asd sads hdaj hdakjshdsahd sakhdkjsahdjas hdakjs hdsakjhda kjshd",
        createdAt = "8 Jan 2024",
        lastEditedAt = "10 Jan 2024",
        noteTag = NoteTag.Journal,
    ),
    NoteApiDto(
        title = "News PM Modi",
        description = "PM Modi goes to ayodhya",
        createdAt = "8 Jan 2024",
        lastEditedAt = "10 Jan 2024",
        noteTag = NoteTag.ToDo,
    ),
    NoteApiDto(
        title = "PM Modi",
        description = "PM Modi goes to laskhdweep",
        createdAt = "8 Jan 2024",
        lastEditedAt = "10 Jan 2024",
        noteTag = NoteTag.Journal,
    ),
    NoteApiDto(
        title = "News Modi",
        description = "PM Modi goes to maldives asdnkjsadn aksda shdkajsh daasd asd sads hdaj hdakjshdsahd sakhdkjsahdjas hdakjs hdsakjhda kjshd",
        createdAt = "8 Jan 2024",
        lastEditedAt = "10 Jan 2024",
        noteTag = NoteTag.Ideas,
    ),
    NoteApiDto(
        title = "News PM Modi",
        description = "PM Modi goes to ayodhya",
        createdAt = "8 Jan 2024",
        lastEditedAt = "10 Jan 2024",
        noteTag = NoteTag.ToDo,
    )
)
