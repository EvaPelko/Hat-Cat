package com.unipu.hatcat

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    val titleImage =R.drawable.hatcattitle

    // Animation setup
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val offsetAnimation = infiniteTransition.animateFloat(
        initialValue = 0f, // Start at the top position
        targetValue = 20f, // Jump to the bottom position
        animationSpec = infiniteRepeatable(
            animation = snap(delayMillis = 500) // Instant change with a delay
        ), label = ""
    )


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to")
        // Hat Cat Image with animation
        Image(
            painter = painterResource(id = titleImage),
            contentDescription = "Hat Cat",
            modifier = Modifier
                .offset(y = -offsetAnimation.value.dp) // Use .value here
        )
        Button(
            onClick = { navController.navigate(Screen.Game.name) },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Start Game")
        }
        Text(text = "The bigger the hat the happier the cat!")
    }
}

