package com.dev.groomi.shared.ui.components.logos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dev.groomi.R
import com.dev.groomi.ui.theme.Spacing

@Composable
fun GroomiLogoSecondary(){
    Image(
        modifier = Modifier.padding(bottom = Spacing.lg),
        painter = painterResource(id = R.drawable.groomi_secondary_logo),
        contentDescription = stringResource(id = R.string.app_name)
    )
}