package com.example.lumen.data.mapper

import com.example.lumen.data.local.MoodEntryEntity
import com.example.lumen.domain.model.MoodEntry
import com.example.lumen.domain.model.MoodLevel

fun MoodEntryEntity.toDomain():
        MoodEntry = MoodEntry(id = id,
                              createdAt = createdAt,
                              mood = MoodLevel.valueOf(mood),
                              emotions = emotions,
                              sensations = sensations,
                              situation = situation,
                              thought = thought,
                              behavior = behavior)

fun MoodEntry.toEntity():
        MoodEntryEntity = MoodEntryEntity(id = id,
                                          createdAt = createdAt,
                                          mood = mood.name,
                                          emotions = emotions,
                                          sensations = sensations,
                                          situation = situation,
                                          thought = thought,
                                          behavior = behavior)