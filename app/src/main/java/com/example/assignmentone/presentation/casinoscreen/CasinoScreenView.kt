package com.example.assignmentone.presentation.ComposeView

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

val books = (1..10).map { "Book $it" }.toList()
val wishlisted = (1..50).map { "Wishlisted Book $it" }

@Composable
fun CasinoScreenView() {
    var nativeCookie="sportsn"
    var CASINO_WEB_URL = "https://casino.nj.betmgm.com/en/games?hideHeader=true&hideClose=true&hideBottombar=true&_nativeApp=casinoodr"
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
                    loadUrl(CASINO_WEB_URL)
                }
            }, update = {
                it.loadUrl(CASINO_WEB_URL)
            })
        }
    }

}