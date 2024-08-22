package com.kirani.appnoblekids

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityQuizShiddiqBinding

class QuizShiddiqActivity : AppCompatActivity() {

    private lateinit var activityQuizShiddiqBinding: ActivityQuizShiddiqBinding

    private val questions = arrayOf("Tata mengembalikan barang milik nina yang ia temukan di kantin",
        "Andi menjawab sudah Ketika ditanyai tentang PR, padahal ia belum mengerjakannya",
        "Rani mencontek dan mendapatkan nilai ujian 100",
        "Lala mengakui kesalahannya yang sudah memecahkan vas milik ibu",
        "Tina tidak mengembalikan kembalian yang lebih kepada penjual buah itu")

    private val options = arrayOf(arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"))

    private val correctAnswers = arrayOf(0,1,1,0,1)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        activityQuizShiddiqBinding = ActivityQuizShiddiqBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(activityQuizShiddiqBinding.root)

        displayQuestion()

        activityQuizShiddiqBinding.option1Button.setOnClickListener {
            checkAnswer(0)
        }

        activityQuizShiddiqBinding.option2Button.setOnClickListener {
            checkAnswer(1)
        }
        activityQuizShiddiqBinding.restartButton.setOnClickListener {
            restartQuiz()
        }
    }

    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> activityQuizShiddiqBinding.option1Button.setBackgroundColor(Color.GREEN)
            1 -> activityQuizShiddiqBinding.option2Button.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongButtonColor(buttonIndex: Int){
        when(buttonIndex){
            0 -> activityQuizShiddiqBinding.option1Button.setBackgroundColor(Color.RED)
            1 -> activityQuizShiddiqBinding.option2Button.setBackgroundColor(Color.RED)
        }
    }
    private fun resetButtonColors(){
        activityQuizShiddiqBinding.option1Button.setBackgroundColor(Color.rgb(255,207,37))
        activityQuizShiddiqBinding.option2Button.setBackgroundColor(Color.rgb(255,207,37))
    }

    private fun showResults(){
        Toast.makeText(this,"Nilaimu : $score dari ${questions.size}", Toast.LENGTH_LONG).show()
        activityQuizShiddiqBinding.restartButton.isEnabled = true
    }
    private fun displayQuestion(){
        activityQuizShiddiqBinding.questionText.text = questions[currentQuestionIndex]
        activityQuizShiddiqBinding.option1Button.text = options[currentQuestionIndex][0]
        activityQuizShiddiqBinding.option2Button.text = options[currentQuestionIndex][1]
        resetButtonColors()
    }
    private fun checkAnswer(selectedAnswerIndex: Int){
        val correctAnswerIndex = correctAnswers[currentQuestionIndex]

        if (selectedAnswerIndex == correctAnswerIndex){
            score++
            correctButtonColors(selectedAnswerIndex)
        } else {
            wrongButtonColor(selectedAnswerIndex)
            correctButtonColors(correctAnswerIndex)
        }
        if (currentQuestionIndex < questions.size - 1){
            currentQuestionIndex++
            activityQuizShiddiqBinding.questionText.postDelayed({displayQuestion()},1000)
        } else {
            showResults()
        }
    }
    private fun restartQuiz(){
        currentQuestionIndex = 0
        score = 0
        displayQuestion()
        activityQuizShiddiqBinding.restartButton.isEnabled = false
    }
}