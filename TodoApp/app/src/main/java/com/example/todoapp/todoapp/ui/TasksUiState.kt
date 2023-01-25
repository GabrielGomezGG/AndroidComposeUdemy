package com.example.todoapp.todoapp.ui

import com.example.todoapp.todoapp.ui.models.TaskModel

sealed interface TasksUiState {
    object Loading:TasksUiState
    data class Error(val throwable: Throwable):TasksUiState
    data class Success(val tasks:List<TaskModel>):TasksUiState
}