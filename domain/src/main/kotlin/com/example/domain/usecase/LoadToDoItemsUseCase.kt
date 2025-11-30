package com.example.domain.usecase

import com.example.domain.model.ToDoItemModel
import com.example.domain.repository.ToDoItemsRepository
import javax.inject.Inject

class LoadToDoItemsUseCase @Inject constructor(
  private val themesRepository: ToDoItemsRepository
) {
  suspend fun execute(): List<ToDoItemModel> {
    return themesRepository.loadToDoItems()
  }
}