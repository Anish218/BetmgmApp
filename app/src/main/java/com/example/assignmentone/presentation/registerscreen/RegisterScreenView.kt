package com.example.assignmentone.presentation.registerscreen

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun RegisterScreenView() {
    var odrCookie="sportswodr"

    val registerUri = "https://www.nj.betmgm.com/en/mobileportal/register?_nativeApp=$odrCookie&hideClose=true&hideBottomBar=true"

    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            loadUrl(registerUri)
        }
    }, update = {
        it.loadUrl(registerUri)
    })
}