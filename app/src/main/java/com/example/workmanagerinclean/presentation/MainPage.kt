package com.example.workmanagerinclean.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun MainPage(onEvent: (MainUiEvent) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            onEvent.invoke(MainUiEvent.GetPost)
        }) {
            Text("Click me")
        }
    }
}