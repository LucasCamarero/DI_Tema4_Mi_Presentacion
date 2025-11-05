package com.lucascamarero.di_tema4_mi_presentacion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lucascamarero.di_tema4_mi_presentacion.screens.VentanaBienvenida
import com.lucascamarero.di_tema4_mi_presentacion.screens.VentanaGallery
import com.lucascamarero.di_tema4_mi_presentacion.screens.VentanaHome
import com.lucascamarero.di_tema4_mi_presentacion.screens.VentanaInfo
import com.lucascamarero.di_tema4_mi_presentacion.screens.VentanaLogin
import com.lucascamarero.di_tema4_mi_presentacion.screens.VentanaSalir
import com.lucascamarero.di_tema4_mi_presentacion.screens.VentanaSettings
import com.lucascamarero.di_tema4_mi_presentacion.ui.theme.DI_Tema4_Mi_PresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DI_Tema4_Mi_PresentacionTheme {
                   VentanaPrincipal()
            }
        }
    }
}

@Preview
@Composable
fun VentanaPrincipal() {

    var navController = rememberNavController()
    val userViewModel: UserViewModel = viewModel()

    Scaffold(
        // barra superior
        topBar = { BarraSuperior() },

        // barra inferior
        bottomBar = { BarraInferior(navController) },

        // floating action button
        floatingActionButton = { FAB() }

        // cuerpo central
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.secondary),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            // definición de rutas de pantallas
            NavHost(
                navController = navController,
                startDestination = "info"
            ) {
                composable("home") {
                    VentanaHome(navController)
                }
                composable("info") {
                    VentanaInfo(navController, userViewModel)
                }
                composable("gallery") {
                    VentanaGallery(navController)
                }
                composable("settings") {
                    VentanaSettings(navController)
                }
                composable("salir") {
                    VentanaSalir(navController)
                }
                composable("login") {
                    VentanaLogin(navController, userViewModel)
                }
                composable("bienvenida") {
                    VentanaBienvenida(navController, userViewModel)
                }
            }
        }
    }
}

// Barra superior
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior() {

    // necesario para los intents
    val context = LocalContext.current

    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.secondary,
        ),
        title = {
            Text(
                "Sobre mí",
                fontSize = 18.sp,
            )
        },
        // INTENT para compartir contenido (icono de redes sociales)
        actions = {
            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "¿Cómo va el día?")
                }
                context.startActivity(Intent.createChooser(intent, "Compartir con"))
            }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Compartir",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    )
}

// Barra Inferior
@Composable
fun BarraInferior(navController: NavHostController) {

    // variables para poder cambiar de color los items al ser seleccionados
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar (containerColor = MaterialTheme.colorScheme.primary){

        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            /*
             * elimino esta línea:
             * selected = navController.currentBackStackEntry?.destination?.route == "home",
             * porque currentBackStackEntry no se actualiza de forma reactiva, por lo que los items quedan
             * "desincronizados" y no se puede cambiar su color dependiendo de si están o no seleccionados.
             * Y pongo la siguiente línea...
            */
            selected = currentRoute == "home",
            onClick = {
                navController.navigate("home") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Home",
                fontSize = 10.sp,
                textAlign = TextAlign.Center) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Info, contentDescription = "info") },
            //selected = navController.currentBackStackEntry?.destination?.route == "info",
            selected = currentRoute == "info",
            onClick = {
                navController.navigate("info") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Info",
                fontSize = 10.sp,
                textAlign = TextAlign.Center) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Create, contentDescription = "gallery") },
            //selected = navController.currentBackStackEntry?.destination?.route == "gallery",
            selected = currentRoute == "gallery",
            onClick = {
                navController.navigate("gallery") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Galería",
                fontSize = 10.sp,
                textAlign = TextAlign.Center) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "settings") },
            //selected = navController.currentBackStackEntry?.destination?.route == "settings",
            selected = currentRoute == "settings",
            onClick = {
                navController.navigate("settings") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Ajustes",
                fontSize = 10.sp,
                textAlign = TextAlign.Center) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Close, contentDescription = "salir") },
            //selected = navController.currentBackStackEntry?.destination?.route == "settings",
            selected = currentRoute == "salir",
            onClick = {
                navController.navigate("salir") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Salir",
                fontSize = 10.sp,
                textAlign = TextAlign.Center) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                indicatorColor = Color.Transparent
            )
        )
    }

    // TEMA 2: BOTONES CON INTENTS EN BARRA INFERIOR
    /*
    val context = LocalContext.current

    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // INTENT para enviar e-mail
            Button(onClick = {
                val recipient = "l.camareroperez@ikasle.eus"
                val subject = "Prueba desde jet compose"
                val body = "Hola Lucas del futuro. Esto es una prueba"
                val uri = ("mailto:$recipient"
                        + "?subject=${Uri.encode(subject)}"
                        + "&body=${Uri.encode(body)}").toUri()
                val intent = Intent(Intent.ACTION_SENDTO).apply { data = uri }
                context.startActivity(intent)
            }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.Email,
                        contentDescription = "Email",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "E-mail",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 12.sp
                    )
                }
            }

            // INTENT IMPLICITO para abrir otra actividad ( OJO!!! hay que
            // añadir el archivo OtraActividad en el Manifest)
            Button(onClick = {
                val intent = Intent(context, OtraActividad::class.java)
                context.startActivity(intent)
            }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Otra actividad",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Actividad",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }*/
}

// Floating Action Button
@Composable
fun FAB() {

    val context = LocalContext.current

    // INTENT para abrir navegador
    FloatingActionButton(
        onClick = {
            val url = "https://developer.android.com/?hl=es-419"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        },
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            Icons.Default.Add,
            contentDescription = "Add",
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(20.dp)
        )
    }
}