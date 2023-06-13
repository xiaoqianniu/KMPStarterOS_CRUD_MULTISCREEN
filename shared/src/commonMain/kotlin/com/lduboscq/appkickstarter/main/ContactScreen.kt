package com.lduboscq.appkickstarter.main

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

internal class ContactScreen: Screen {
    @Composable
    override fun Content() {
        Scaffold (
            topBar = { MyTopBar() }
                ) {
            Text("please contact us")
        }
    }

}