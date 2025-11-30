package com.example.domain.repository

import com.example.domain.model.ToDoItemModel

interface ToDoItemsRepository {
  suspend fun loadToDoItems(): List<ToDoItemModel>
}