package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class Naver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_naver)

        val web : WebView = findViewById(R.id.webView)
        web.settings.javaScriptEnabled = true // 자바 스크립트 허용
        // 다음 두 줄은 새 창이 뜨지 않도록 방지 하는 구문
        web.webViewClient = WebViewClient()
        web.webChromeClient = WebChromeClient()

        web.loadUrl("https://www.naver.com")
    }
}