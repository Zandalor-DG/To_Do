package com.example.to_do.ui.home_screen

import com.example.domain.model.ToDoItemModel

sealed class HomeScreenStates {
    data object IdleState : HomeScreenStates()
    data object LoadingState : HomeScreenStates()
    data class ErrorState(val message: String) : HomeScreenStates()
    data class HomeState(val data: List<ToDoItemModel>) : HomeScreenStates()
}

sealed class HomeScreenEvents {
    data object LoadToDoItems : HomeScreenEvents()
}