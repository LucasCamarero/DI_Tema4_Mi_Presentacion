package com.lucascamarero.di_tema4_mi_presentacion

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    // Animación de escala para rebote
    val scale = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 4000,
                easing = { OvershootInterpolator(4f).getInterpolation(it) }
            )
        )
        delay(2000) // 2 segundos antes de pasar a la siguiente pantalla

        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .scale(scale.value)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Mercado de la Ribera",
                modifier = Modifier.size(270.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 65.dp, vertical = 15.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                elevation = CardDefaults.cardElevation(6.dp), // sombra
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                    //.background(Color.DarkGray),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "Lucas Camarero",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 25.sp,
                        color = MaterialTheme.colorScheme.tertiaryContainer
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Desarrollador Android",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.tertiaryContainer
                    )
                }
            }
        }
    }
}