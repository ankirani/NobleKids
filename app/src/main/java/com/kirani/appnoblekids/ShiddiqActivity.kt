package com.kirani.appnoblekids

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityShiddiqBinding

class ShiddiqActivity : AppCompatActivity() {

    private lateinit var activityShiddiqBinding: ActivityShiddiqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityShiddiqBinding = ActivityShiddiqBinding.inflate(layoutInflater)
        setContentView(activityShiddiqBinding.root)

        val webView: WebView = activityShiddiqBinding.webView

        val video : String = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/nQAnx2l4rFo?si=3jnet6IHQclK3bsh\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(video,"text/html","utf-8")
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()

        activityShiddiqBinding.backButton.setOnClickListener {
            val Intent = Intent(this,LearningActivity::class.java)
            startActivity(Intent)
        }

    }
}