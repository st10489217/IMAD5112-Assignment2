package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.MessageQueue
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class activity_questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

    }

    private val questions = arrayOf(
        "Nelson Mandela died in 2013." ,
        "The First World War is known as the Forgotten War." ,
        "Treaties is a formal agreement between governments." ,
        "An alliance is someone who is going against you." ,
        "The world has 5 continents."
    )
    private val answers = arrayOf(true , false , true , false , false)
    private var currentQuestionIndex = 0
    private var score = 0
    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var nextButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle? , persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState , persistentState)
        questionTextView = findViewById(R.id.questionText)
        feedbackTextView = findViewById(R.id.feedbackText)
        trueButton = findViewById<Button>(R.id.trueButton)
        falseButton = findViewById<Button>(R.id.falseButton)
        nextButton = findViewById(R.id.nextbutton)

        displayQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
            } else {
                val intent =
                    Intent(this , activity_score::class.java)
                intent.putExtra("Score" , score)
                intent.putExtra("Questions" , questions)
                intent.putExtra("Answers" , answers)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun displayQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
        feedbackTextView.text = ""
        nextButton.isEnabled = false
        trueButton.isEnabled = true
        falseButton.isEnabled= true
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correct = answers[currentQuestionIndex]
        if (userAnswer == correct) {
            feedbackTextView.text = "Correct!"
            score++
        } else {
            feedbackTextView.text = "Incorrect!"
        }
        trueButton.isEnabled= false
            falseButton.isEnabled = false
        nextButton.isEnabled = true
    }
}