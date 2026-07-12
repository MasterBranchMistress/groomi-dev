package com.dev.groomi.shared.ui.components.logos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dev.groomi.R
import com.dev.groomi.ui.theme.Dimensions

@Composable
fun GroomiLogoMain(modifier: Modifier = Modifier){
    Image(
        modifier = Modifier.size(Dimensions.LogoSizeMedium),
        painter = painterResource(id = R.drawable.groomi_main_logo),
        contentDescription = stringResource(id = R.string.app_name)
    )
}