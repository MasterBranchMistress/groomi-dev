package com.dev.groomi.shared.ui.components.background

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.dev.groomi.R

@OptIn(UnstableApi::class)
@Composable
fun GroomiVideoBackground(enabled: Boolean = true) {
    val context = LocalContext.current
    val player = remember {
        ExoPlayer.Builder(context)
            .build()
            .apply {
                val uri = RawResourceDataSource.buildRawResourceUri(
                    R.raw.groomi_login_background_video
                )

                setMediaItem(MediaItem.fromUri(uri))
                repeatMode = Player.REPEAT_MODE_ALL
                playWhenReady = true
                prepare()
            }
    }

    DisposableEffect(Unit) {
        onDispose {
            player.release()
        }
    }
if(enabled){
    AndroidView(
        factory = {
            PlayerView(it).apply {
                this.player = player
                useController = false
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
}