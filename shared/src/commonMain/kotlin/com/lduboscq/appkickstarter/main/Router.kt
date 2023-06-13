package com.lduboscq.appkickstarter.main

import cafe.adriel.voyager.core.screen.Screen

sealed class AllScreens {
    object Home : AllScreens()
    object About:AllScreens()
    object Contact:AllScreens()
}

fun ScreenRouter(screen: AllScreens): Screen {
    return when (screen) {
        is AllScreens.Home ->
            MainScreen()

        is AllScreens.About ->
            AboutScreen()

        is AllScreens.Contact ->
            ContactScreen()

    }
}