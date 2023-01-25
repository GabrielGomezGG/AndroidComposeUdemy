package com.example.todoapp.todoapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Preview
@Composable
fun TasksScreen(/*taskViewModel: TaskViewModel*/) {
    Box(modifier = Modifier.fillMaxSize()) {
        FabDialog(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
        AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
    }
}


@Composable
fun FabDialog(modifier: Modifier = Modifier) {

    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = modifier
    ) {
        Icon(Icons.Filled.Add, contentDescription = "")
    }
}

@Composable
fun AddTasksDialog(show: Boolean, onDismiss: () -> Unit, onTaskAdded:(String)->Unit) {
    var myTask by rememberSaveable {
        mutableStateOf("")
    }

    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Añade una tarea",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(value = myTask, onValueChange = { myTask = it }, singleLine = true, maxLines = 1)
                Spacer(modifier = Modifier.size(16.dp))
                Button(
                    onClick = { onTaskAdded(myTask) },
                    Modifier.fillMaxWidth()
                ) {
                    Text(text = "Añadir tarea")
                }
            }
        }
    }
}