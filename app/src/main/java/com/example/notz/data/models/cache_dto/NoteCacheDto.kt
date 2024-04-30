package com.example.notz.data.models.cache_dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notz.domain.models.Note
import com.example.notz.domain.models.NoteTag

@Entity(tableName = "notes")
data class NoteCacheDto(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "created_at") val createdAt: String,
    @ColumnInfo(name = "last_edited_at") val lastEditedAt: String,
    @ColumnInfo(name = "note_tag") val noteTag: NoteTag
)

fun NoteCacheDto.toModel(): Note = Note(
    id = id,
    title = title,
    description = description,
    createdAt = createdAt,
    lastEditedAt = lastEditedAt,
    noteTag = noteTag,
)