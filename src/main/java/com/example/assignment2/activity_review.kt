package com.example.assignment2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class activity_review : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val reviewTextView = findViewById<TextView>(R.id.reviewText)
        val reviewText = intent.getStringExtra("Review Text") ?: "No review available"
        reviewTextView.text= reviewText
    }
}