package com.example.assignmentone.presentation

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.assignmentone.R

@Composable
fun SplashScreenView(

    navController: NavController
){
    val progressValue = 0.90f
    val infiniteTransition = rememberInfiniteTransition()
    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue,animationSpec = infiniteRepeatable(animation = tween(900)))
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        Text(
            modifier = Modifier.padding(start = 140.dp, top = 130.dp),
            color = colorResource(id = R.color.dark_gold),
            text = "BET",
            fontSize = 25.sp
        )
        Text(
            modifier = Modifier.padding(start = 180.dp, top = 130.dp),

            color = colorResource(id = com.example.assignmentone.R.color.gold),
            text = "MGM",
            fontSize = 25.sp
        )
        Text(
            modifier = Modifier.padding(start = 160.dp, top = 160.dp),

            color = Color.White,
            text = "NEW JERSEY",
            fontSize = 10.sp
        )

        CircularProgressIndicator(
            color = colorResource(id = com.example.assignmentone.R.color.gold),
            modifier = Modifier.padding(start = 170.dp,top = 500.dp),
            progress = progressAnimationValue
        )

    }



}