package com.example.implicitintent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webview=findViewById<WebView>(R.id.Webview)
        webviewSetUp(webview)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webviewSetUp(webView: WebView){
        webView.webViewClient= WebViewClient()
        webView.apply{
            settings.safeBrowsingEnabled=true
            settings.javaScriptEnabled=true
            loadUrl("https://9900riya.github.io/portfolio.github.io/")

        }

    }


}