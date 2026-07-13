package com.dev.groomi.shared.ui.components.logos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dev.groomi.R
import com.dev.groomi.ui.theme.Dimensions
import com.dev.groomi.ui.theme.Spacing

@Composable
fun GroomiLogoMain(modifier: Modifier = Modifier){
    Image(
        modifier = Modifier.padding(bottom = Spacing.lg).fillMaxSize(),
        painter = painterResource(id = R.drawable.groomi_main_logo),
        contentDescription = stringResource(id = R.string.app_name)
    )
}