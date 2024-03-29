package com.example.todoapp.todoapp.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.todoapp.domain.AddTaskUseCase
import com.example.todoapp.todoapp.domain.DeleteTaskUseCase
import com.example.todoapp.todoapp.domain.GetTasksUseCase
import com.example.todoapp.todoapp.domain.UpdateTaskUseCase
import com.example.todoapp.todoapp.ui.TasksUiState.Success
import com.example.todoapp.todoapp.ui.models.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    getTasksUseCase: GetTasksUseCase
) : ViewModel() {

    val uiState:StateFlow<TasksUiState> = getTasksUseCase().map(::Success)
        .catch { TasksUiState.Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TasksUiState.Loading)

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog : LiveData<Boolean> = _showDialog;


    fun onDialogClose() {
        _showDialog.value = false;
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onTaskCreate(task: String) {
        _showDialog.value = false

        viewModelScope.launch {
            addTaskUseCase(TaskModel(task = task))
        }
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        viewModelScope.launch {
            updateTaskUseCase(taskModel.copy(selected = !taskModel.selected))
        }
    }

    fun onItemRemove(taskModel: TaskModel) {
        viewModelScope.launch {
            deleteTaskUseCase(taskModel)
        }
    }
}