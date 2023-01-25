package com.example.todoapp.todoapp.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.todoapp.ui.models.TaskModel
import javax.inject.Inject

class TaskViewModel @Inject constructor(

) : ViewModel() {

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog : LiveData<Boolean> = _showDialog;

    private val _task = mutableStateListOf<TaskModel>()
    val task : List<TaskModel> = _task

    fun onDialogClose() {
        _showDialog.value = false;
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onTaskCreate(task: String) {
        Log.i("titi", task)
        _showDialog.value = false
        _task.add(TaskModel(task = task))
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        TODO("Not yet implemented")
    }
}