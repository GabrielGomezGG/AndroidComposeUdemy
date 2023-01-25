package com.example.todoapp.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.todoapp.data.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TodoDataBase : RoomDatabase(){
    abstract fun taskDao():TaskDao
}