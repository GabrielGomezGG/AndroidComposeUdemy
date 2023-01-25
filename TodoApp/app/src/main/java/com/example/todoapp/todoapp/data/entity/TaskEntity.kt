package com.example.todoapp.todoapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
    @PrimaryKey
    val id : Int,
    val task : String,
    val selected : Boolean = false
)
