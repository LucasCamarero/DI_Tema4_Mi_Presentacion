package com.lucascamarero.di_tema4_mi_presentacion.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucascamarero.di_tema4_mi_presentacion.R

// Tarea optativa 1: INTENT para elegir y compartir imágenes del móvil
// Tarea optativa 2: DATA CLASS
@Composable
fun VentanaGallery(navController: NavController) {

    val context = LocalContext.current
    val launcher = ElegirYCompartirImagen(context)
    var presses by remember { mutableIntStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Tarea 1
        item {
            Button(
                onClick = {
                    launcher.launch("image/*")
                },
                modifier = Modifier.padding(30.dp)
            ) {
                Text("Imágenes")
            }
        }

        // Tarea 2
        item {
            MessageCard(
                msg = Message("Lexi", "Nº toques de botón: ", presses)
            )
        }
    }
}

@Composable
fun ElegirYCompartirImagen(context: Context): ManagedActivityResultLauncher<String, Uri?> {
    val seleccionImagenLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "image/*"
                putExtra(Intent.EXTRA_STREAM, it)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            context.startActivity(
                Intent.createChooser(intent, "Compartir imagen con...")
            )
        }
    }
    return seleccionImagenLauncher
}

// clase para crear un mensaje
data class Message(val author: String, val body: String, val toquesBoton: Int)


// muestra un mensaje
@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.comida),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(horizontal = 8.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.tertiaryContainer, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.tertiaryContainer,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = msg.body + msg.toquesBoton,
                color = MaterialTheme.colorScheme.tertiaryContainer,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}