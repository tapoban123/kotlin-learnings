package com.example.viewmodelkotlin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun StateTestScreen(viewModel: StateTestViewModel) {
    val name by viewModel.name.observeAsState(initial = "")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyText(name = name)
        MyTextField(name = name, onChanged = {
            viewModel.updateName(it)
        })

    }
}

@Composable
fun MyText(name: String) {
    Text("Hello $name", fontSize = 30.sp)
}

@Composable
fun MyTextField(name: String, onChanged: (String) -> Unit) {
    OutlinedTextField(
        value = name,
        onValueChange = onChanged, label = { Text(text = "Enter name") }
    )
}