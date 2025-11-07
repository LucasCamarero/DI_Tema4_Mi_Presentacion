package com.lucascamarero.di_tema4_mi_presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.launch

// Tarea optativa: SNACKBAR
@Composable
fun VentanaHome(navController: NavController) {

    // estado que gestiona el Snackbar (es como el "controlador" del mensaje)
    val snackbarHostState = remember { SnackbarHostState() }
    // corrutina scope para lanzar tareas en segundo plano (necesario para mostrar el Snackbar)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            //.padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                // iniciamos una corrutina para mostrar el mensaje
                scope.launch {
                    snackbarHostState.showSnackbar("¡Hola desde Home!")
                }
            }, colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary)
        ) {
            Text("Mostrar Snackbar",
                style = MaterialTheme.typography.bodySmall)
        }

        // componente que muestra realmente el Snackbar en pantalla

        SnackbarHost(
            hostState = snackbarHostState
        ) { data ->
            Snackbar(
                snackbarData = data,
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }
    }
}