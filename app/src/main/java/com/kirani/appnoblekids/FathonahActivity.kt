package com.kirani.appnoblekids

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityFathonahBinding

class FathonahActivity : AppCompatActivity() {

    private lateinit var activityFathonahBinding: ActivityFathonahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityFathonahBinding = ActivityFathonahBinding.inflate(layoutInflater)
        setContentView(activityFathonahBinding.root)

        val webView: WebView = activityFathonahBinding.webView

        val video : String = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/a3isgHpRAFg?si=2Aw2g5A227jK5u-8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(video,"text/html","utf-8")
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()

        activityFathonahBinding.backButton.setOnClickListener {
            val Intent = Intent(this,LearningActivity::class.java)
            startActivity(Intent)
        }

    }
}