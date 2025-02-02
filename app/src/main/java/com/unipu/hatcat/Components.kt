package com.unipu.hatcat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NeedProgressBar(need: String, progress: Float) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = need)
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .size(width = 100.dp, height = 10.dp)
                .padding(top = 4.dp)
        )
    }
}