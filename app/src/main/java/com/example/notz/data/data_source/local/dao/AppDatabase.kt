package com.example.notz.data.data_source.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notz.data.models.cache_dto.NoteCacheDto

@Database(entities = [NoteCacheDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): NoteDao

    abstract val noteDao: NoteDao
    companion object{
        const val DB_NAME = "notes_db"
    }
}