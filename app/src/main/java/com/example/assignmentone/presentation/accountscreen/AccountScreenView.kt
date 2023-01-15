package com.example.assignmentone.presentation.ComposeView

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.assignmentone.R


fun Modifier.shimmerBackground(shape: Shape = RectangleShape): Modifier = composed {
    val transition = rememberInfiniteTransition()
    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 400f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1500, easing = LinearOutSlowInEasing),
            RepeatMode.Restart
        ),
    )
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.4f),
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(translateAnimation, translateAnimation),
        end = Offset(translateAnimation + 100f, translateAnimation + 100f),
        tileMode = TileMode.Mirror,
    )
    return@composed this.then(background(brush, shape))
}


@Composable
fun AccountScreenView() {
    var nativeCookie="sportsn"
    var ACCOUNT_WEB_URL = "https://sports.nj.betmgm.com/en/menu?_nativeApp=$nativeCookie&hideClose=true&hideBottomBar=true"
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
//        Box(
//            modifier = Modifier
//                .padding(start = 0.dp)
//                .fillMaxWidth()
//                .height(40.dp)
//
//
//        ){
//            Column(
//                modifier = Modifier.padding(start = 10.dp)
//            ) {
//
//                Row() {
//
//
//                    Text(
//                        color = colorResource(id = com.example.assignmentone.R.color.gold),
//                        text = "BET",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 20.sp
//                    )
//                    Text(
//                        color = colorResource(id = com.example.assignmentone.R.color.gold),
//                        text = "MGM",
//                        fontWeight = FontWeight.ExtraBold,
//                        fontSize = 20.sp
//                    )}
//                Text(
//                    color = colorResource(id = com.example.assignmentone.R.color.white),
//                    text = "NEW JERSEY",
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 12.sp
//                )
//
//            }
//
//            Image(
//
//                painter = painterResource(R.drawable.ic_baseline_cancel_24),
//                contentDescription = "",
//                modifier = Modifier
//                    .padding(top = 6.dp, start = 360.dp, end = 6.dp, bottom = 6.dp)
//                    .size(35.dp)
//                    .clip(shape = CircleShape)
//                    .clickable { navigate(R.id.action_accountFragment_to_lobbyFragment) }
//
//            )
//
//        }
        Box(modifier = Modifier
            .background(Color.Green)
            .fillMaxSize()
        ) {
            Text(text = " hi")
            AndroidView(factory = {
                WebView(it).apply {

                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true
                    loadUrl(ACCOUNT_WEB_URL)
                }
            }, update = {
                it.loadUrl(ACCOUNT_WEB_URL)
            })
        }
    }

}


//@Composable
//fun AccountScreenView(navigate: (Int) -> Unit){
//    var nativeCookie="sportsn"
//    var ACCOUNT_WEB_URL = "https://sports.nj.betmgm.com/en/menu?_nativeApp=$nativeCookie&hideClose=true&hideBottomBar=true"
//
//   Row(
//       modifier = Modifier.background(Color.Blue)
//   ) {
//       Text(text = "hi", color = Color.White)
//   }
//    Column() {
//        AndroidView(factory = {
//            WebView(it).apply {
//                layoutParams = ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT
//                )
//                webViewClient = WebViewClient()
//                loadUrl(ACCOUNT_WEB_URL)
//            }
//        }, update = {
//            it.loadUrl(ACCOUNT_WEB_URL)
//        })
//
//    }
//
//}