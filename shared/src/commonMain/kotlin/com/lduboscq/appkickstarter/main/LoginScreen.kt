package com.lduboscq.appkickstarter.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen

internal class LoginScreen : Screen {
    @Composable
    override fun Content() {
        var count by remember { mutableStateOf(0) }

        Scaffold (
            topBar = { MyTopBar() }
        ) {
            myLoginForm(count = count, setCount = { newCount -> count = newCount })
        }
    }
}