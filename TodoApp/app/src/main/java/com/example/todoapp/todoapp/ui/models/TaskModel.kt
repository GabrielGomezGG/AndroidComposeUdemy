package com.example.todoapp.todoapp.ui.models

data class TaskModel(
    val id : Int = System.currentTimeMillis().hashCode(),
    val task : String,
    val selected : Boolean = false
) {

}
