package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class activity_score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
    }
    private lateinit var scoreTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var reviewButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle? , persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState , persistentState)
        scoreTextView = findViewById(R.id.scoreText)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        reviewButton = findViewById(R.id.reviewButton)
        exitButton = findViewById(R.id.exitButton)
        val score = intent.getIntExtra("Score" , 0)
        val questions= intent.getStringArrayExtra("Questions")?: emptyArray()
        val answers= intent.getBooleanArrayExtra("Answers")?: BooleanArray(0)

        scoreTextView.text="Your score: $score out of ${questions.size}"
        feedbackTextView.text= if
                (score>= 3) {
            "Great job!"
        }else{
            "Keep practising"
        }
        reviewButton.setOnClickListener {
            val reviewTextView= StringBuilder()
            for (i in questions.indices){
                reviewTextView.append("${i+1}.${questions[i]} -> ${answers[i]}\n\n")
            }
            val intent=
                Intent(this,activity_review::class.java)
            intent.putExtra("ReviewText", reviewTextView.toString())
            startActivity(intent)
        }
        exitButton.setOnClickListener { finishAffinity()
        // Completely closes the app
        }
    }
}
