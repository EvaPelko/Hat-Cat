package com.unipu.hatcat

import android.widget.Toast
import androidx.activity.result.launch
import androidx.compose.animation.core.copy
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun GameScreen() {
    var cat by remember { mutableStateOf(Cat()) }
    val context = LocalContext.current
    var showWinToast by remember { mutableStateOf(false) }
    var clicksRemaining by remember { mutableStateOf(20) }

    val catImage = if (cat.isHappy()) {
        R.drawable.cat_finish
    } else {
        R.drawable.cat
    }

    LaunchedEffect(key1 = cat.isHappy()) {
        if (cat.isHappy()) {
            showWinToast = true
        }
    }

    if (showWinToast) {
        Toast.makeText(context, "You Win!", Toast.LENGTH_SHORT).show()
        showWinToast = false
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Progress Bars
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            NeedProgressBar(need = "Hunger", progress = cat.hunger)
            NeedProgressBar(need = "Thirst", progress = cat.thirst)
            NeedProgressBar(need = "Tiredness", progress = cat.tiredness)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Cat Image
        Image(
            painter = painterResource(id = catImage),
            contentDescription = "Cat",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { if (clicksRemaining > 0) {
                cat = cat.copy(
                    hunger = (cat.hunger + 0.2f).coerceAtMost(1f),
                    thirst = (cat.thirst - 0.1f).coerceAtLeast(0f)
                )
                clicksRemaining--
            }
            },
                enabled = clicksRemaining > 0
            ){
                Image(
                    painter = painterResource(R.drawable.feed),
                    contentDescription = "feed the cat",
                )
            }
            Button(onClick = { if (clicksRemaining > 0) {
                cat = cat.copy(
                    thirst = (cat.thirst + 0.2f).coerceAtMost(1f),
                    tiredness = (cat.tiredness - 0.1f).coerceAtLeast(0f)
                )

                clicksRemaining--
            }
            },
                enabled = clicksRemaining > 0
            ) {
                Image(
                    painter = painterResource(R.drawable.drink),
                    contentDescription = "quench thirst",
                )
            }
            Button(onClick = { if (clicksRemaining > 0) {
                cat = cat.copy(tiredness = (cat.tiredness + 0.2f).coerceAtMost(1f)
                )

                clicksRemaining--
            }
            },
                enabled = clicksRemaining > 0
            ) {
                Image(
                    painter = painterResource(R.drawable.sleep),
                    contentDescription = "make cat sleep",
                )
            }
        }
        Text(text = "Clicks Remaining: $clicksRemaining")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {Button(onClick = { cat = Cat(); clicksRemaining = 20 }) {
            Text(text = "Retry")
        }
        }
    }
}



