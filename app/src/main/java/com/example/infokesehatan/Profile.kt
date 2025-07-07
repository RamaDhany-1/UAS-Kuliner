package com.example.infokesehatan

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.infokesehatan.ui.theme.InfoKesehatanTheme

@Composable
fun Profile(modifier: Modifier = Modifier, navController: NavController) {
    // Mengambil argumen "msg" jika ada dari navigasi sebelumnya
    val msg = navController.currentBackStackEntry?.savedStateHandle?.get<String>("msg")

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Seorang yang selalu berusaha mengejar impian dengan " +
                    "\"belajar tekun dan tak kenal lelah\".",
            modifier = Modifier.padding(30.dp),
            overflow = TextOverflow.Clip,
            color = Color.Green,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { navController.navigate(route = "homescreen") }
        ) {
            Text(text = "Go to Home Screen")
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Menampilkan teks dari argumen "msg" jika tidak null
        msg?.let { Text(it) }
    }
}

@Composable
fun ProfileScreen(navController: NavController) {
    InfoKesehatanTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation(navController)
            }
        ) { padding ->
            Profile(Modifier.padding(padding), navController)
        }
    }
}