package com.example.englishassistant.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.englishassistant.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                NavHost(navController = navController, startDestination = "HomeScreen") {
                    composable("homeScreen") { HomeScreen(context, navController) }
                    composable("recordingScreen") { RecordingScreen() }
                }
            }
        }
    }
}