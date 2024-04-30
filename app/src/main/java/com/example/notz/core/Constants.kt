package com.example.notz.core

import com.example.notz.data.models.api_dto.NoteApiDto
import com.example.notz.domain.models.NoteTag

val notes = listOf(
    NoteApiDto(
        id = 0,
        title = "New Idea",
        description = "This is my new idea that works well",
        createdAt = "8 Jan 2024",
        lastEditedAt = "16 Feb 2024",
        noteTag = NoteTag.Ideas,
    ),
    NoteApiDto(
        id = 1,
        title = "News Modi",
        description = "PM Modi goes to maldives asdnkjsadn aksda shdkajsh daasd asd sads hdaj hdakjshdsahd sakhdkjsahdjas hdakjs hdsakjhda kjshd",
        createdAt = "8 Jan 2024",
        lastEditedAt = "10 Jan 2024",
        noteTag = NoteTag.Journal,
    ),
    NoteApiDto(
        id = 2,
        title = "News Modi",
        description = "PM Modi goes to maldives asdnkjsadn aksda shdkajsh daasd asd sads hdaj hdakjshdsahd sakhdkjsahdjas hdakjs hdsakjhda kjshd",
        createdAt = "8 Jan 2024",
        lastEditedAt = "10 Jan 2024",
        noteTag = NoteTag.Journal,
    ),
    NoteApiDto(
        id = 3,
        title = "News Modi",
        description = "PM Modi goes to maldives asdnkjsadn aksda shdkajsh daasd asd sads hdaj hdakjshdsahd sakhdkjsahdjas hdakjs hdsakjhda kjshd",
        createdAt = "8 Jan 2024",
        lastEditedAt = "10 Jan 2024",
        noteTag = NoteTag.Journal,
    ),
)
