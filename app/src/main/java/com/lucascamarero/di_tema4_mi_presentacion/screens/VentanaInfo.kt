package com.lucascamarero.di_tema4_mi_presentacion.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucascamarero.di_tema4_mi_presentacion.R
import com.lucascamarero.di_tema4_mi_presentacion.UserViewModel

@Composable
fun VentanaInfo(navController: NavController, userViewModel: UserViewModel) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        item {
            // imagen foto
            Image(
                painter = painterResource(id = R.drawable.foto_luken),
                contentDescription = "Imagen presentación",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .size(180.dp)
                    .border(width = 5.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape)
                    .clip(CircleShape)
            )
            // texto con mi nombre
            Text(
                "Lucas Camarero",
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
                //fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
            // texto de introducción
            Text(
                textoIntro(),
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            // Educación
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)
                    .padding(horizontal = 12.dp)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.educacion),
                        contentDescription = "Imagen educacion",
                        modifier = Modifier
                            .size(65.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary, BlendMode.SrcIn)
                    )
                    LazyColumn(
                        modifier = Modifier
                            // Lazy column aquí necesita saber qué altura puede ocupar
                            .height(100.dp)
                            .padding(horizontal = 10.dp)
                    ) {
                        item {
                            Text(
                                "Educación",
                                modifier = Modifier
                                    .padding(top = 3.dp, bottom = 11.dp)
                                    .fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Left
                            )

                            Text(
                                "Estudiante de D.A.M.",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Left
                            )
                        }
                    }
                }
            }
            // Deportes
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)
                    .padding(horizontal = 12.dp)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.deportes),
                        contentDescription = "Imagen deportes",
                        modifier = Modifier
                            .size(65.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary, BlendMode.SrcIn)
                    )
                    LazyColumn(
                        modifier = Modifier
                            // Lazy column aquí necesita saber qué altura puede ocupar
                            .height(100.dp)
                            .padding(horizontal = 10.dp)
                    ) {
                        item {
                            Text(
                                "Deportes",
                                modifier = Modifier
                                    .padding(top = 3.dp, bottom = 11.dp)
                                    .fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Left
                            )

                            Text(
                                "Gimnasio, andar, montaña",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Left
                            )
                        }
                    }
                }
            }
            // Comida
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)
                    .padding(horizontal = 12.dp)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.comida),
                        contentDescription = "Imagen comida",
                        modifier = Modifier
                            .size(65.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary, BlendMode.SrcIn)
                    )
                    LazyColumn(
                        modifier = Modifier
                            // Lazy column aquí necesita saber qué altura puede ocupar
                            .height(100.dp)
                            .padding(horizontal = 10.dp)
                    ) {
                        item {
                            Text(
                                "Comida",
                                modifier = Modifier
                                    .padding(top = 3.dp, bottom = 11.dp)
                                    .fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Left
                            )

                            Text(
                                "Rodaballo, besugo, chuleta",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Left
                            )
                        }
                    }
                }
            }
            // Hobbies
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)
                    .padding(horizontal = 12.dp)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.hobbies),
                        contentDescription = "Imagen hobbies",
                        modifier = Modifier
                            .size(65.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary, BlendMode.SrcIn)
                    )
                    LazyColumn(
                        modifier = Modifier
                            // Lazy column aquí necesita saber qué altura puede ocupar
                            .height(100.dp)
                            .padding(horizontal = 10.dp)
                    ) {
                        item {
                            Text(
                                "Hobbies",
                                modifier = Modifier
                                    .padding(top = 3.dp, bottom = 11.dp)
                                    .fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Left
                            )

                            Text(
                                "Música, tocar el bajo",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Left
                            )
                        }
                    }
                }
            }
            // iconos redes sociales
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)
                    .padding(horizontal = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                item {
                    // github
                    Image(
                        painter = painterResource(id = R.drawable.github),
                        contentDescription = "Imagen github",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(top = 5.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                    )
                }
                item {
                    // linkedin
                    Image(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = "Imagen github",
                        modifier = Modifier
                            .size(55.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                    )
                }
                item {
                    // instagram
                    Image(
                        painter = painterResource(id = R.drawable.instagram),
                        contentDescription = "Imagen instagram",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(top = 5.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                    )
                }
            }

            // boton para ir a la ventana Login
            Button(onClick = {
                navController.navigate("login")
            },
                modifier = Modifier.padding(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )) {
                Text("Ir a Loggin",
                    style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

// retorna un texto de introducción
fun textoIntro(): String {
    val texto = "Soy un estudiante de programación D.A.M. aficionado a la música y " +
            "al deporte que está haciendo un proyecto de IU con kotlin y jet pack compose"

    return texto
}
