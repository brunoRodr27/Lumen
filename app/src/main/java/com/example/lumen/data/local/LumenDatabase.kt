package com.example.lumen.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [MoodEntryEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)

abstract class LumenDatabase : RoomDatabase() {
    abstract fun moodDao(): MoodDao
}