package com.example.lumen.presentation.wizard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lumen.domain.model.*
import com.example.lumen.domain.usecase.SaveMoodEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WizardViewModel @Inject constructor(private val saveEntry: SaveMoodEntryUseCase) : ViewModel() {
    private val _state = MutableStateFlow(WizardState())
    val state = _state.asStateFlow()

    fun selectMood(mood: MoodLevel) { _state.update { it.copy(mood = mood) } }

    fun toggleEmotion(emotion: String) = _state.update {
        val list = it.emotions.toMutableList()
        if (emotion in list) list.remove(emotion) else list.add(emotion)
        it.copy(emotions = list)
    }

    fun toggleSensation(sensation: String) = _state.update {
        val list = it.sensations.toMutableList()
        if (sensation in list) list.remove(sensation) else list.add(sensation)
        it.copy(sensations = list)
    }

    fun updateContext(situation: String, thought: String, behavior: String) =  _state.update {
        it.copy(situation = situation, thought = thought, behavior = behavior)
    }

    fun next() = _state.update {
        it.copy(step = it.step.next())
    }

    fun previous() = _state.update {
        it.copy(step = it.step.previous())
    }

    fun save() {
        val s = _state.value
        val mood = s.mood ?:
        return _state.update { it.copy(isSaving = true, error = null) }
        viewModelScope.launch {
            val entry = MoodEntry(createdAt = System.currentTimeMillis(),
                                  mood = mood,
                                  emotions = s.emotions,
                                  sensations = s.sensations,
                                  situation = s.situation,
                                  thought = s.thought,
                                  behavior = s.behavior)
            
            saveEntry(entry)
                .onSuccess { id -> _state.update { it.copy(isSaving = false, savedId = id) } }
                .onFailure { e -> _state.update { it.copy(isSaving = false, error = e.message) } }
        }
    }
}