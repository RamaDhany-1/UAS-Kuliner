package com.example.infokesehatan

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.infokesehatan.MyHealthApp
import com.example.infokesehatan.ProfileScreen

@Composable
fun Navigation(widthSizeClass: WindowWidthSizeClass) { // Terima parameter di sini
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "homescreen"
    ) {
        composable("homescreen") {
            // Berikan parameter itu ke MyHealthApp
            MyHealthApp(navController, widthSizeClass)
        }
        composable("profilescreen") {
            ProfileScreen(navController)
        }
    }
}