package com.example.pmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat

class ColourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colour)

        val backButtonColourPage: ImageButton = findViewById<ImageButton>(R.id.backButtonColourPage)
        backButtonColourPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }
    }
}