package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

@Composable
fun MyBottomBar() {
    val navigator = LocalNavigator.currentOrThrow
    BottomAppBar {
        Button(onClick = {
            navigator.push(ScreenRouter(AllScreens.ItemList))
        }) {
            Text("ItemList")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(onClick = {
            navigator.push(ScreenRouter(AllScreens.Profile))
        }) {
            Text("Profile")
        }
        Button(onClick = {
            navigator.push(ScreenRouter(AllScreens.Contact))
        }) {
            Text("Contact")
        }
    }
}