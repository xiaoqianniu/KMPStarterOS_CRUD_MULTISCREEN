package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

@Composable
fun MyTopBar(){
    var count by remember { mutableStateOf(0) }
    val navigator = LocalNavigator.currentOrThrow
    TopAppBar(title =
    {
        Text(
            "Welcome!  $count",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h4,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Button(onClick={
            navigator.push(ScreenRouter(AllScreens.ItemList))
        }) {
            Text("ItemList")
        }

    })
}