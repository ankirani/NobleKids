package com.kirani.appnoblekids

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityAmanahBinding

class AmanahActivity : AppCompatActivity() {

    private lateinit var activityAmanahBinding: ActivityAmanahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityAmanahBinding = ActivityAmanahBinding.inflate(layoutInflater)
        setContentView(activityAmanahBinding.root)

        val webView: WebView = activityAmanahBinding.webView

        val video : String = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/du1AxZMVq3E?si=0F--qfB7KEtMjarE\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(video,"text/html","utf-8")
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()

        activityAmanahBinding.backButton.setOnClickListener {
            val Intent = Intent(this,LearningActivity::class.java)
            startActivity(Intent)
        }

    }
}