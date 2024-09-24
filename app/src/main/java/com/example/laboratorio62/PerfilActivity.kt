package com.example.laboratorio62

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio62.R

class PerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfilScreen()  // Esta llamada debe estar dentro de setContent
        }
    }
}

// Aquí la función debe estar marcada como @Composable
@Composable
fun PerfilScreen() {
    // Estado del interruptor para notificaciones
    var notificacionesEnabled by remember { mutableStateOf(false) }

    // Fondo con degradado geométrico
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF6200EA), // Morado
                        Color(0xFFBB86FC), // Rosado
                        Color(0xFF03DAC5)  // Azul
                    )
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        // Contenido principal
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Icono circular de usuario
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.LightGray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.greenday), // Asegúrate de tener este recurso
                    contentDescription = "Ícono de usuario",
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre de usuario
            Text(
                text = "Cecilia Castillo",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón Editar Perfil
            Button(
                onClick = { /* Acción para editar perfil */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC))
            ) {


            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón Restablecer Contraseña
            Button(
                onClick = { /* Acción para restablecer contraseña */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03DAC5))
            ) {
                //Text("Restablecer Contraseña")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Toggle para Notificaciones
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { notificacionesEnabled = !notificacionesEnabled }
            ) {
                Text(
                    text = "Notificaciones",
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = notificacionesEnabled,
                    onCheckedChange = { notificacionesEnabled = it },
                    colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFFBB86FC))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón Favoritos
            TextButton(
                onClick = { /* Acción para acceder a Favoritos */ },
                modifier = Modifier.fillMaxWidth()
            ) {

                //Text(
                //text = "Favoritos",
                //fontSize = 18.sp,
                //color = Color(0xFF03DAC5),
                //fontWeight = FontWeight.Bold
                //)
            }
        }
    }
}

// Función de previsualización para Jetpack Compose
@Preview(showBackground = true)
@Composable
fun PreviewPerfilScreen() {
    PerfilScreen()
}
