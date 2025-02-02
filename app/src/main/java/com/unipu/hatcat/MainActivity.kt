package com.unipu.hatcat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unipu.hatcat.ui.theme.HatCatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HatCatTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    HatCatApp()
                }
            }
        }
    }
}

enum class Screen {
    Menu,
    Game,
    GameWin
}

@Composable
fun HatCatApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Menu.name) {
        composable(Screen.Menu.name) { MenuScreen(navController) }
        composable(Screen.Game.name) { GameScreen() }
        composable(Screen.GameWin.name) { GameWinScreen(navController) }
    }
}