package com.lucascamarero.di_tema4_mi_presentacion.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucascamarero.di_tema4_mi_presentacion.UserViewModel

// Tarea: VIEW MODEL
@Composable
fun VentanaLogin(navController: NavController, userViewModel: UserViewModel) {

    var texto by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            OutlinedTextField(
                value = texto,
                onValueChange = { nuevoTexto ->
                    texto = nuevoTexto },
                label = { Text("Escribe un número") },
                isError = error
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {

                if(texto.toIntOrNull() != null) {
                    var n = texto.toInt()
                    userViewModel.setNum(n)   // Guardamos en el ViewModel
                    navController.navigate("bienvenida")
                } else {
                    error = true
                }
            }) {
                Text("Entrar")
            }
        }
    }
}