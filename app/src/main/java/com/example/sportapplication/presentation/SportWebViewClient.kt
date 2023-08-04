package com.example.sportapplication.presentation

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class SportWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        view.loadUrl(request.url.toString())
        return true
    }
}