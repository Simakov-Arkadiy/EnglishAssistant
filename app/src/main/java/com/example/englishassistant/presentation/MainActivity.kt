package com.example.englishassistant.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.englishassistant.presentation.di.App
import com.example.englishassistant.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val app = application as App

        val factory = app.appComponent
            .recordScreenViewModelFactory()

        setContent {
            AppTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                NavHost(navController = navController, startDestination = "HomeScreen") {
                    composable("homeScreen") { HomeScreen(context, navController) }
                    composable("recordingScreen") { RecordScreen(viewModel(factory = factory)) }
                }
            }
        }
    }
}