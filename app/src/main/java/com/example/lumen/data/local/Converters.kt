package com.example.lumen.data.local

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

class Converters {
    private val json = Json

    @TypeConverter
    fun fromList(value: List<String>): String = json.encodeToString(ListSerializer(String.serializer()), value)

    @TypeConverter
    fun toList(value: String): List<String> = json.decodeFromString(ListSerializer(String.serializer()), value)
}