package com.kirani.appnoblekids

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        activityHomeBinding.buttonLearning.setOnClickListener {
            val Intent = Intent(this,LearningActivity::class.java)
            startActivity(Intent)
        }

        activityHomeBinding.buttonTantangan.setOnClickListener {
            val Intent = Intent(this,ChallengeActivity::class.java)
            startActivity(Intent)
        }

    }
}