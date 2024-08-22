package com.kirani.appnoblekids

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityChallengeBinding

class ChallengeActivity : AppCompatActivity() {

    private lateinit var activityChallengeBinding: ActivityChallengeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityChallengeBinding = ActivityChallengeBinding.inflate(layoutInflater)
        setContentView(activityChallengeBinding.root)

        activityChallengeBinding.buttonAmanah.setOnClickListener {
            val Intent = Intent(this,QuizAmanahActivity::class.java)
            startActivity(Intent)
        }

        activityChallengeBinding.buttonShiddiq.setOnClickListener {
            val Intent = Intent(this,QuizShiddiqActivity::class.java)
            startActivity(Intent)
        }

        activityChallengeBinding.buttonTabligh.setOnClickListener {
            val Intent = Intent(this,QuizTablighActivity::class.java)
            startActivity(Intent)
        }

        activityChallengeBinding.buttonFathonah.setOnClickListener {
            val Intent = Intent(this, QuizFathonahActivity::class.java)
            startActivity(Intent)
        }

    }
}