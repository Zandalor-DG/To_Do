package com.example.to_do.ui.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.LoadToDoItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val loadToDoItemsUseCase: LoadToDoItemsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<HomeScreenStates>(HomeScreenStates.IdleState)
    val state: StateFlow<HomeScreenStates>
        get() = _state


    fun obtainEvent(event: HomeScreenEvents) {
        when (event) {
            HomeScreenEvents.LoadToDoItems -> loadThemes()
        }
    }

    private fun loadThemes() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = HomeScreenStates.LoadingState
                val result = loadToDoItemsUseCase.execute()
                _state.value = HomeScreenStates.HomeState(result)
            }
        }
    }
}