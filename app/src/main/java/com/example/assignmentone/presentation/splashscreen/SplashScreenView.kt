package com.example.assignmentone.presentation

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmentone.R
import com.example.assignmentone.presentation.splashscreen.SplashScreenViewModel

@Composable
fun SplashScreenView(

    splashScreenViewModel: SplashScreenViewModel,
    exitApp: () -> Unit
){
    val dynaconApiSuccess by splashScreenViewModel.isDynaconApiSuccess.observeAsState()
    val networkconnected by splashScreenViewModel.isNetworkConnected.observeAsState()

    val progressValue = 0.90f
    val infiniteTransition = rememberInfiniteTransition()
    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue,animationSpec = infiniteRepeatable(animation = tween(900)))
    val showDialog = remember { mutableStateOf(false) }
    showDialog.value= !dynaconApiSuccess!!
    val showDialogForNetwork = remember { mutableStateOf(false) }
    showDialogForNetwork.value= !networkconnected!!
   // println(showDialog.value)

    Card() {
        if (showDialog.value!!) {
            AlertDialog(
                title = {
                    Text("Attention!!")
                },
                text = {
                    Text(text = "Dynacon Api Failed to succeed")
                },
                onDismissRequest = {showDialog.value=false},
                confirmButton = {
                    TextButton(onClick = {
                        println("cliekd")
                        showDialog.value=false
                        exitApp()

                    }

                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {}
            )
        }
    }
    Card() {
        if (showDialogForNetwork.value!!) {
            AlertDialog(
                title = {
                    Text("Attention!!")
                },
                text = {
                    Text(text = "Please Connect to a Network")
                },
                onDismissRequest = {showDialog.value=false},
                confirmButton = {
                    TextButton(onClick = {
                        println("cliekd")
                        showDialog.value=false
                        exitApp()

                    }

                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {}
            )
        }
    }
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(start = 140.dp, top = 130.dp),
            color = colorResource(id = R.color.dark_gold),
            text = "BET",
            fontSize = 30.sp
        )
        Text(
            modifier = Modifier.padding(start = 195.dp, top = 130.dp),

            color = colorResource(id = com.example.assignmentone.R.color.gold),
            text = "MGM",
            fontSize = 30.sp
        )
        Spacer(Modifier.height(5.dp))
        Text(
            modifier = Modifier.padding(start = 160.dp, top = 165.dp),

            color = Color.White,
            text = "NEW JERSEY",
            fontSize = 15.sp
        )

        CircularProgressIndicator(
            color = colorResource(id = com.example.assignmentone.R.color.gold),
            modifier = Modifier.padding(start = 170.dp,top = 500.dp),
            progress = progressAnimationValue
        )

    }



}


