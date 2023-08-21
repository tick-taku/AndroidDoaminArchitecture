package tick.taku.android.feature.cat.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import tick.taku.android.core.entity.Cat
import tick.taku.android.domain.cat.CatDomain
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject internal constructor(
    private val domain: CatDomain
): ViewModel() {

    data class UiState(
        val cats: List<Cat> = emptyList()
    )

    sealed interface UiEvent {
        data class Error(val e: Throwable): UiEvent
    }

    val uiState: StateFlow<UiState> = domain.cats().map { UiState(it) }.stateIn(UiState())

    private val _uiEvent: Channel<UiEvent> = Channel()
    val uiEvent: Flow<UiEvent> = _uiEvent.receiveAsFlow()

    fun fetchCats() {
        viewModelScope.launch {
            domain.fetch()
        }
    }

    private fun <T> Flow<T>.stateIn(initialValue: T): StateFlow<T> {
        return stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), initialValue)
    }
}