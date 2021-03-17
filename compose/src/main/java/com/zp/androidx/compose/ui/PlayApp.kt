package com.zp.androidx.compose.ui

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.zp.androidx.compose.ui.home.Home
import com.zp.androidx.compose.ui.snackdetail.SnackDetail
import com.zp.androidx.compose.ui.theme.PlayTheme
import com.zp.androidx.compose.ui.utils.Navigator
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

/**
 * Created by zhaopan on 2021/3/17
 */

@Composable
fun PlayApp(backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSaveable(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }
    val actions = remember(navigator) {Actions(navigator)}
    ProvideWindowInsets {
        PlayTheme {
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    Destination.Home -> Home(actions.selectSnack)
                    is Destination.SnackDetail -> SnackDetail(
                        snackId = destination.snackId,
                        upPress = actions.upPress
                    )
                }
            }
        }
    }
}