package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

@Composable
fun loginInfoDisplay(email: String, password: String, onBackClicked: () -> Unit) {
    val navigator = LocalNavigator.currentOrThrow
    Card(
        modifier = Modifier.padding(top = 16.dp).fillMaxSize(),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.primaryVariant
    ) {
        Column(
            modifier = Modifier.padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Welcome back! ",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "User Information",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Email: $email",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Password: $password",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = {
                onBackClicked()
            }) {
                Text("Back", fontSize = 20.sp)
            }
            Button(onClick={
                navigator.push(ScreenRouter(AllScreens.About))
            }) {
               Text("Home")
            }
        }
    }
}