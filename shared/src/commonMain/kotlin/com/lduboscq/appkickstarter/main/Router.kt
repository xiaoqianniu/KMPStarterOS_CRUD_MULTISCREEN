package com.lduboscq.appkickstarter.main

import cafe.adriel.voyager.core.screen.Screen

sealed class AllScreens {
    object Home : AllScreens()
    object Login : AllScreens()
    object Contact : AllScreens()
    object ItemList : AllScreens()

    object Profile :AllScreens()
}

fun ScreenRouter(screen: AllScreens): Screen {
    return when (screen) {
        is AllScreens.Home ->
            MainScreen()

        is AllScreens.Login ->
            LoginScreen()

        is AllScreens.Contact ->
            ContactScreen()

        is AllScreens.ItemList ->
            ItemListScreen()

        is AllScreens.Profile->
            ProfileScreen()
    }
}