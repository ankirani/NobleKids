package com.kirani.appnoblekids

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityQuizFathonahBinding

class QuizFathonahActivity : AppCompatActivity() {

    private lateinit var activityQuizFathonahBinding: ActivityQuizFathonahBinding

    private val questions = arrayOf("Hani membuat kerajinan tangan sebagai hadiah untuk ibunya",
        "Mila tertidur di kelas karena semalam begadang keasyikan main game",
        "Alia menabung Ketika ingin membelli sesuatu yang ia inginkan",
        "Azka marah kepada ibunya karena tidak membelikan mainan yang ia ingin",
        "Bayu bolos sekolah karena malas mengikuti ujian harian")

    private val options = arrayOf(arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"))

    private val correctAnswers = arrayOf(0,1,0,1,1)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        activityQuizFathonahBinding = ActivityQuizFathonahBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(activityQuizFathonahBinding.root)

        displayQuestion()

        activityQuizFathonahBinding.option1Button.setOnClickListener {
            checkAnswer(0)
        }

        activityQuizFathonahBinding.option2Button.setOnClickListener {
            checkAnswer(1)
        }
        activityQuizFathonahBinding.restartButton.setOnClickListener {
            restartQuiz()
        }

    }

    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> activityQuizFathonahBinding.option1Button.setBackgroundColor(Color.GREEN)
            1 -> activityQuizFathonahBinding.option2Button.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongButtonColor(buttonIndex: Int){
        when(buttonIndex){
            0 -> activityQuizFathonahBinding.option1Button.setBackgroundColor(Color.RED)
            1 -> activityQuizFathonahBinding.option2Button.setBackgroundColor(Color.RED)
        }
    }
    private fun resetButtonColors(){
        activityQuizFathonahBinding.option1Button.setBackgroundColor(Color.rgb(255,207,37))
        activityQuizFathonahBinding.option2Button.setBackgroundColor(Color.rgb(255,207,37))
    }

    private fun showResults(){
        Toast.makeText(this,"Nilaimu : $score dari ${questions.size}", Toast.LENGTH_LONG).show()
        activityQuizFathonahBinding.restartButton.isEnabled = true
    }
    private fun displayQuestion(){
        activityQuizFathonahBinding.questionText.text = questions[currentQuestionIndex]
        activityQuizFathonahBinding.option1Button.text = options[currentQuestionIndex][0]
        activityQuizFathonahBinding.option2Button.text = options[currentQuestionIndex][1]
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
            activityQuizFathonahBinding.questionText.postDelayed({displayQuestion()},1000)
        } else {
            showResults()
        }
    }
    private fun restartQuiz(){
        currentQuestionIndex = 0
        score = 0
        displayQuestion()
        activityQuizFathonahBinding.restartButton.isEnabled = false
    }


}