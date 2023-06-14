package com.lduboscq.appkickstarter.main

import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

internal class ProfileScreen: Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Button(onClick = {
            navigator.push(ScreenRouter(AllScreens.Home))
        }) {
            androidx.compose.material.Text("Home")
        }
    }

}