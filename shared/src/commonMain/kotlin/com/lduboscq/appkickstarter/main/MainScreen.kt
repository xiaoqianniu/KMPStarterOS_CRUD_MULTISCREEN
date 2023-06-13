package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.ExperimentalResourceApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lduboscq.appkickstarter.ui.Image

//sealed class AllScreens{
//    data class Home(val name:String):AllScreens()
//    data class About(val count:Int):AllScreens()
//}
//@Composable
//fun screenRouter(screen: AllScreens){
//    val navigator = LocalNavigator.currentOrThrow
//    when(screen){
//        is AllScreens.Home -> {navigator.push(HomeScreen(name = screen.name))}
//        is AllScreens.About -> {
//            if (screen.count == 0) {
//                navigator.push(AboutScreen(message = "Welcome"))
//            } else {
//                navigator.push(AboutScreen(message = "welcome back"))
//            }
//        }
//    }
//}

internal class MainScreen :Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        var count by remember { mutableStateOf(0) }
        Scaffold(
            topBar = { MyTopBar()},
            bottomBar = { MyBottomBar() }
//                TopAppBar(title =
//                {
//                    Text(
//                        "Welcome!  $count",
//                        color = MaterialTheme.colors.onPrimary,
//                        style = MaterialTheme.typography.h4,
//                        fontFamily = FontFamily.Cursive,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.fillMaxWidth(),
//                    )
//                }


            )
        {

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    url="https://images.pexels.com/photos/895259/pexels-photo-895259.jpeg",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize(),
                    alpha = 0.8F
                )
                myLoginForm(count = count, setCount = { newCount -> count = newCount })
            }
        }
    }
}