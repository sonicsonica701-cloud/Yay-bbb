package com.example.mybrowser

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the WebView programmatically
        val myWebView = WebView(this)
        setContentView(myWebView)

        // Enable JavaScript (needed for most modern sites)
        myWebView.settings.javaScriptEnabled = true
        
        // Ensure links open in this app, not the external browser
        myWebView.webViewClient = WebViewClient()

        // Load a starting URL (e.g., Google or DuckDuckGo)
        myWebView.loadUrl("https://duckduckgo.com")

        // Handle the "Back" button so it goes back in browser history 
        // instead of closing the app immediately
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (myWebView.canGoBack()) {
                    myWebView.goBack()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }
}