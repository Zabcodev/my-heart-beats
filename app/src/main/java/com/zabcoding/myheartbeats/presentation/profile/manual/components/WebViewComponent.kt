package com.zabcoding.myheartbeats.presentation.profile.manual.components

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewComponent(baseUrl: String) {

    AndroidView(factory = { context ->
        WebView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(baseUrl)
        }
    }, update = { webView ->
        webView.loadUrl(baseUrl)
    })


}