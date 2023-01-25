package com.example.todoapp.todoapp.domain

import com.example.todoapp.todoapp.data.TaskRepository
import com.example.todoapp.todoapp.ui.models.TaskModel
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
){
    suspend operator  fun invoke(taskModel: TaskModel){
        taskRepository.delete(taskModel)
    }
}