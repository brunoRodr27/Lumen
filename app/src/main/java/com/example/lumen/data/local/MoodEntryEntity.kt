package com.example.lumen.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mood_entries")
data class MoodEntryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val createdAt: Long,
    val mood: String,             // nome do MoodLevel, ex: "POSITIVE"
    val emotions: List<String>,   // convertido por TypeConverter
    val sensations: List<String>, // convertido por TypeConverter
    val situation: String,
    val thought: String,
    val behavior: String
)