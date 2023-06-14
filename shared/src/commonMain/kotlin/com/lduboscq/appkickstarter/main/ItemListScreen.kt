package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

internal class ItemListScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column {
       Text("If you usually connect to the internet using a Wi-Fi network, make sure you’re connected to the Wi-Fi network.\n" +
               "\n" +
               "If you’re connected to the Wi-Fi network but you can’t connect to the internet, there might be a problem with the network’s internet connection. If you set up the Wi-Fi network using an AirPort device (such as an AirPort Extreme), you can get information about the device and its internet connection by using AirPort Utility. For more help while using AirPort Utility, choose Help > AirPort Utility Help.")
        Button(onClick = {
            navigator.push(ScreenRouter(AllScreens.Home))
        }) {
            androidx.compose.material.Text("Home")
        }
        }
    }

}