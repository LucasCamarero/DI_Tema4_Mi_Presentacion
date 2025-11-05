package com.lucascamarero.di_tema4_mi_presentacion

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucascamarero.di_tema4_mi_presentacion.ui.theme.DI_Tema4_Mi_PresentacionTheme
import kotlin.jvm.java

// Tarea optativa: INTENT para abrir otra actividad
class OtraActividad : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DI_Tema4_Mi_PresentacionTheme (
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = false
            ) {
                ventana2()
            }
        }
    }
}

@Composable
fun ventana2() {

    val context = LocalContext.current

    Surface {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            item {
                Text(
                    "Página de prueba para abrir otras actividades" +
                            " en una aplicación mediante Intents en vez de" +
                            " navController",
                    modifier = Modifier
                        .padding(20.dp),
                    textAlign = TextAlign.Center
                )

                // INTENT para abrir otra actividad ( OJO!!! tiene que estar añadido
                // el archivo MainActivity en el Manifest)
                Button(onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Otra actividad",
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.size(25.dp)
                        )
                        Text(
                            text = "Home",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}