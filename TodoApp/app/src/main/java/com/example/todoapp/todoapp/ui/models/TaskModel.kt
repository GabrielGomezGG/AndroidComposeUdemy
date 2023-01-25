package com.example.todoapp.todoapp.ui.models

data class TaskModel(
    val id : Long = System.currentTimeMillis(),
    val task : String,
    val selected : Boolean = false
) {

}
