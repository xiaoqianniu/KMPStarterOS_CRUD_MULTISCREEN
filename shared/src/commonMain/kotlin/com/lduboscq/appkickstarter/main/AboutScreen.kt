package com.lduboscq.appkickstarter.main

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

internal class AboutScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold (
            topBar = { MyTopBar() }
        ) {
            Text("I am about")
        }
    }
}