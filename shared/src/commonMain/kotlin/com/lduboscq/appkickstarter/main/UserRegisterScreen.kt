package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.lduboscq.appkickstarter.FrogCard
import com.lduboscq.appkickstarter.FrogRepositoryRealmRealmLocal
import com.lduboscq.appkickstarter.FrogScreenModel

class UserRegisterScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel() { UserScreenModel(UserRepositoryRealmLocal()) }
        val state by screenModel.state.collectAsState()
        var userName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        Column {
            when (val result = state) {
                is UserScreenModel.State.Init -> Text("Just initialized")
                is UserScreenModel.State.Loading -> Text("Loading")
                is UserScreenModel.State.Result -> {
                    Text("Success")
                }
            }

            Text("Please enter userName to add/get/update/delete")

            Card(modifier = Modifier.padding(15.dp), elevation = 10.dp) {
                TextField(
                    value = userName,
                    onValueChange = { userName = it },
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                    label = { Text("Enter username") },
                    leadingIcon = {
                        Icon(Icons.Filled.Face, contentDescription = "username icon")
                    },
                    singleLine = true
                )
            }
            Card(modifier = Modifier.padding(15.dp), elevation = 10.dp) {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                    label = { Text("Enter email address") },
                    leadingIcon = {
                        Icon(Icons.Filled.Email, contentDescription = "email icon")
                    },
                    singleLine = true
                )
            }
            Card(modifier = Modifier.padding(15.dp), elevation = 10.dp) {
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                    label = { Text("Enter password") },
                    leadingIcon = {
                        Icon(Icons.Filled.Lock, contentDescription = "password icon")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true
                )
            }
            Card(modifier = Modifier.padding(15.dp), elevation = 10.dp) {
                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                    label = { Text("Enter confirm password") },
                    leadingIcon = {
                        Icon(Icons.Filled.Lock, contentDescription = "password icon")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true
                )
            }
            if (!userName.isNullOrEmpty() && !email.isNullOrEmpty() && !password.isNullOrEmpty() && !confirmPassword.isNullOrEmpty()) {

                Button(onClick = { screenModel.addUser(userName,email,password,confirmPassword) }) {
                    Text("Add New User")
                }
            }

            if (!userName.isNullOrEmpty()) {
                Button(onClick = { screenModel.getUser(userName,email,password,confirmPassword) }) {
                    Text("Get User")
                }
            }

            if (state is UserScreenModel.State.Result.SingleResult) { Text("The results of the action are:")
                UserCard(userData =(state as UserScreenModel.State.Result.SingleResult).userData)
            }
        }
    }
}