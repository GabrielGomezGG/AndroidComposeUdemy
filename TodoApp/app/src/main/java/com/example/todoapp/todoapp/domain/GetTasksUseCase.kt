package com.example.todoapp.todoapp.domain

import com.example.todoapp.todoapp.data.TaskRepository
import com.example.todoapp.todoapp.ui.models.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    operator  fun invoke():Flow<List<TaskModel>>{
        return taskRepository.tasks
    }
}