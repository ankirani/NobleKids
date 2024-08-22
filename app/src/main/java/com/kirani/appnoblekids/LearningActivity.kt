package com.kirani.appnoblekids

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityLearningBinding

class LearningActivity : AppCompatActivity() {

    private lateinit var activityLearningBinding: ActivityLearningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLearningBinding = ActivityLearningBinding.inflate(layoutInflater)
        setContentView(activityLearningBinding.root)

        activityLearningBinding.buttonAmanah.setOnClickListener {
            val Intent = Intent(this,AmanahActivity::class.java)
            startActivity(Intent)
        }

        activityLearningBinding.buttonFathonah.setOnClickListener {
            val Intent = Intent(this,FathonahActivity::class.java)
            startActivity(Intent)
        }

        activityLearningBinding.buttonTabligh.setOnClickListener {
            val Intent = Intent(this,TablighActivity::class.java)
            startActivity(Intent)
        }

        activityLearningBinding.buttonShiddiq.setOnClickListener {
            val Intent = Intent(this,ShiddiqActivity::class.java)
            startActivity(Intent)
        }

        activityLearningBinding.buttonBackhome.setOnClickListener {
            val Intent = Intent(this,HomeActivity::class.java)
            startActivity(Intent)
        }

    }
}