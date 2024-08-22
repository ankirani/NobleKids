package com.kirani.appnoblekids

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityTablighBinding

class TablighActivity : AppCompatActivity() {

    private lateinit var activityTablighBinding: ActivityTablighBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTablighBinding = ActivityTablighBinding.inflate(layoutInflater)
        setContentView(activityTablighBinding.root)

        val webView: WebView = activityTablighBinding.webView

        val video : String = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3pgrVdYa7Fs?si=sFXPyA4Ep7fJnJEP\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(video,"text/html","utf-8")
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()

        activityTablighBinding.backButton.setOnClickListener {
            val Intent = Intent(this,LearningActivity::class.java)
            startActivity(Intent)
        }
    }
}