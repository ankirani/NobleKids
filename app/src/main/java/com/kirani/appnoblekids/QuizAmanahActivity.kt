package com.kirani.appnoblekids

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityQuizAmanahBinding

class QuizAmanahActivity : AppCompatActivity() {

    private lateinit var activityQuizAmanahBinding: ActivityQuizAmanahBinding

    private val questions = arrayOf("Nia berjanji tidak akan mengatakan kepada siapapun apa yang sinta sampaikan kepadanya",
        "Nita datang ke acara pertemuan jam 8 padahal ia berkata kepada roni akan datang tepat waktu yaitu jam 7 ",
        "Randy menaati segala peraturan lalu lintas saat sedang mengendarai motor",
        "Lia menolak saat disuruh ikut serta berbuat jail kepada temannya ",
        "Tina tidak mengerjakan PR yang disuruh pak guru ")

    private val options = arrayOf(arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"))

    private val correctAnswers = arrayOf(0,1,0,0,1)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        activityQuizAmanahBinding = ActivityQuizAmanahBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(activityQuizAmanahBinding.root)

        displayQuestion()

        activityQuizAmanahBinding.option1Button.setOnClickListener {
            checkAnswer(0)
        }

        activityQuizAmanahBinding.option2Button.setOnClickListener {
            checkAnswer(1)
        }
        activityQuizAmanahBinding.restartButton.setOnClickListener {
            restartQuiz()
        }

    }

    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> activityQuizAmanahBinding.option1Button.setBackgroundColor(Color.GREEN)
            1 -> activityQuizAmanahBinding.option2Button.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongButtonColor(buttonIndex: Int){
        when(buttonIndex){
            0 -> activityQuizAmanahBinding.option1Button.setBackgroundColor(Color.RED)
            1 -> activityQuizAmanahBinding.option2Button.setBackgroundColor(Color.RED)
        }
    }
    private fun resetButtonColors(){
        activityQuizAmanahBinding.option1Button.setBackgroundColor(Color.rgb(255,207,37))
        activityQuizAmanahBinding.option2Button.setBackgroundColor(Color.rgb(255,207,37))
    }

    private fun showResults(){
        Toast.makeText(this,"Nilaimu : $score dari ${questions.size}", Toast.LENGTH_LONG).show()
        activityQuizAmanahBinding.restartButton.isEnabled = true
    }
    private fun displayQuestion(){
        activityQuizAmanahBinding.questionText.text = questions[currentQuestionIndex]
        activityQuizAmanahBinding.option1Button.text = options[currentQuestionIndex][0]
        activityQuizAmanahBinding.option2Button.text = options[currentQuestionIndex][1]
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
            activityQuizAmanahBinding.questionText.postDelayed({displayQuestion()},1000)
        } else {
            showResults()
        }
    }
    private fun restartQuiz(){
        currentQuestionIndex = 0
        score = 0
        displayQuestion()
        activityQuizAmanahBinding.restartButton.isEnabled = false
    }
}