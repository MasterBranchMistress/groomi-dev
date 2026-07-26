package com.dev.groomi.shared.ui.components.background

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.dev.groomi.ui.theme.RoyalOrchid
import kotlin.random.Random

data class Particle(
    val x: Float,
    val y: Float,
    val radius: Float
)

@Composable
fun GroomiScreenBackground() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        val particles = remember {
            List(30) {
                Particle(
                    x = Random.nextFloat(),
                    y = Random.nextFloat(),
                    radius = Random.nextFloat() * 8f + 2f
                )
            }
        }

        val transition = rememberInfiniteTransition()

        val offset by transition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                repeatMode = RepeatMode.Reverse,
                animation = tween(
                    durationMillis = 10000,
                    easing = LinearEasing
                )
            )
        )

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            particles.forEach { particle ->
                drawCircle(
                    color = RoyalOrchid,
                    radius = particle.radius,
                    center = androidx.compose.ui.geometry.Offset(
                        x = particle.x * size.width,
                        y = ((particle.y + offset * .05f) % 1f) * size.height
                    ),
                    alpha = .30f
                )
            }
        }
    }
}