package com.tahirahearle.ucc

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Twitter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter)

        val web: WebView = findViewById(R.id.wvSocial)
        web.webViewClient = CustWebViewClient(this)
        web.loadUrl("https://www.twitter.com/uccjamaica/")

        val webSettings = web.settings
        webSettings.javaScriptEnabled = true
    }
}
//Allows external website to load within WebView element
class CustWebViewClient internal constructor(private val activity: Activity) :
    WebViewClient() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        val url: String = request?.url.toString();
        view?.loadUrl(url)
        return true
    }
    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        webView.loadUrl(url)
        return true
    }
    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest,
        error: WebResourceError
    ) {
        Toast.makeText(activity, "Error! $error", Toast.LENGTH_SHORT).show()
    }
}