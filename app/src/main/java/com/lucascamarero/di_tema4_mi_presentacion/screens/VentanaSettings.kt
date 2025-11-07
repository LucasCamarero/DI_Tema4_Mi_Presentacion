package com.lucascamarero.di_tema4_mi_presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// Tarea optativa: CHECKBOX
@Composable
fun VentanaSettings(navController: NavController) {

    var checked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        //.background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.tertiaryContainer, // color del check marcado
                    uncheckedColor = MaterialTheme.colorScheme.tertiaryContainer, // color del borde cuando está desmarcado
                    checkmarkColor = MaterialTheme.colorScheme.onPrimary // color del símbolo dentro del check
                )
            )

            Text(text = if (checked) "Notificaciones activadas"
            else "Notificaciones desactivadas",
                color = MaterialTheme.colorScheme.tertiaryContainer,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 20.sp)
        }
    }
}