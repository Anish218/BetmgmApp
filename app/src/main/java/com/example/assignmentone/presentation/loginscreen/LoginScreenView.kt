package com.example.assignmentone.presentation.loginscreen

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.assignmentone.R


@Composable
fun LoginScreenView(){
    var odrCookie="sportswodr"
    var LOGIN_WEB_URL = "https://sports.nj.betmgm.com/en/labelhost/login?_nativeApp=$odrCookie&hideClose=true&hideBottomBar=true"
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
//        Box(
//            modifier = Modifier
//                .padding(start = 0.dp)
//                .fillMaxWidth()
//                .height(50.dp)
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
//                        color = colorResource(id = R.color.gold),
//                        text = "BET",
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 20.sp
//                    )
//                    Text(
//                        color = colorResource(id = R.color.gold),
//                        text = "MGM",
//                        fontWeight = FontWeight.ExtraBold,
//                        fontSize = 20.sp
//                    )}
//                Text(
//                    color = colorResource(id = R.color.white),
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
//                    .clickable { navigate(R.id.action_loginFragment_to_sportsFragment) }
//
//            )
//
//        }
        Box(modifier = Modifier
            .background(Color.Green)
            .fillMaxSize()
        ) {

            AndroidView(factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true
                    loadUrl(LOGIN_WEB_URL)
                }
            }, update = {
                it.loadUrl(LOGIN_WEB_URL)
            })
        }
    }
}