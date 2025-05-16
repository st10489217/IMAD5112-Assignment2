package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ButtonStart=findViewById<Button>(R.id.ButtonStart)

        ButtonStart.setOnClickListener{
            val intent = Intent(this , activity_questions::class.java)
            startActivity(intent)
            finish()
        }
    }
}