package com.kirani.appnoblekids

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kirani.appnoblekids.databinding.ActivityQuizTablighBinding

class QuizTablighActivity : AppCompatActivity() {

    private lateinit var activityQuizTablighBinding: ActivityQuizTablighBinding

    private val questions = arrayOf("Ketua kelas menyampaikan apa saja pesan yang ibu guru sampaikan",
        "Sindy menyampaikan pesan yang dititipi oleh pak guru kepada teman-teman sekelas",
        "Salman mengajari teman-temannya yang belum terlalu memahami pelajaran matematika",
        "Rina memetik bunga di taman sekolah meskipun sudah diperingati temannya",
        "Riko menemukan uang 10 ribu dikelas, kemudian ia umumkan agar dapat mengetahui siapa yang sudah kehilangan uang")

    private val options = arrayOf(arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"), arrayOf("Benar", "Salah"))

    private val correctAnswers = arrayOf(0,0,0,1,0)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityQuizTablighBinding = ActivityQuizTablighBinding.inflate(layoutInflater)
        setContentView(activityQuizTablighBinding.root)

        displayQuestion()

        activityQuizTablighBinding.option1Button.setOnClickListener {
            checkAnswer(0)
        }

        activityQuizTablighBinding.option2Button.setOnClickListener {
            checkAnswer(1)
        }
        activityQuizTablighBinding.restartButton.setOnClickListener {
            restartQuiz()
        }
    }

    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> activityQuizTablighBinding.option1Button.setBackgroundColor(Color.GREEN)
            1 -> activityQuizTablighBinding.option2Button.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongButtonColor(buttonIndex: Int){
        when(buttonIndex){
            0 -> activityQuizTablighBinding.option1Button.setBackgroundColor(Color.RED)
            1 -> activityQuizTablighBinding.option2Button.setBackgroundColor(Color.RED)
        }
    }
    private fun resetButtonColors(){
        activityQuizTablighBinding.option1Button.setBackgroundColor(Color.rgb(255,207,37))
        activityQuizTablighBinding.option2Button.setBackgroundColor(Color.rgb(255,207,37))
    }

    private fun showResults(){
        Toast.makeText(this,"Nilaimu : $score dari ${questions.size}", Toast.LENGTH_LONG).show()
        activityQuizTablighBinding.restartButton.isEnabled = true
    }
    private fun displayQuestion(){
        activityQuizTablighBinding.questionText.text = questions[currentQuestionIndex]
        activityQuizTablighBinding.option1Button.text = options[currentQuestionIndex][0]
        activityQuizTablighBinding.option2Button.text = options[currentQuestionIndex][1]
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
            activityQuizTablighBinding.questionText.postDelayed({displayQuestion()},1000)
        } else {
            showResults()
        }
    }
    private fun restartQuiz(){
        currentQuestionIndex = 0
        score = 0
        displayQuestion()
        activityQuizTablighBinding.restartButton.isEnabled = false
    }
}