package com.lucascamarero.di_tema4_mi_presentacion.screens

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

// Tarea optativa: ALERT DIALOG para cerrar la app
@Composable
fun VentanaSalir(navController: NavController) {

    // obtiene el contexto actual de la app (necesario para cerrar la actividad)
    val context = LocalContext.current
    val activity = context as? Activity

    // variable de estado para controlar si se muestra el diálogo
    var mostrarDialogo by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.secondary),
        //.background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (mostrarDialogo) {

            AlertDialog(
                onDismissRequest = {
                    // si el usuario cierra el diálogo sin tocar botones
                    mostrarDialogo = false
                    navController.popBackStack() // volver atrás
                },
                title = {
                    Text(text = "Salir de la aplicación")
                },
                text = {
                    Text("¿Estás seguro de que deseas salir?")
                },
                confirmButton = {
                    TextButton(onClick = {
                        activity?.finish() // cierra la actividad
                    }) {
                        Text("Sí")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        mostrarDialogo = false
                        navController.popBackStack() // vuelve atrás
                    }) {
                        Text("No")
                    }
                }
            )
        }
    }
}