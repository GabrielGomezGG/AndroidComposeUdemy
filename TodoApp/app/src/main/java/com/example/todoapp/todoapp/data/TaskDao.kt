package com.example.todoapp.todoapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.todoapp.data.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("select * from TaskEntity")
    fun getTasks() : Flow<List<TaskEntity>>

    @Insert
    suspend fun addTask(task : TaskEntity)

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

}