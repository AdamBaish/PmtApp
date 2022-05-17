package com.example.pmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textButton: Button = findViewById<Button>(R.id.text_button)
        textButton.setOnClickListener {
            val intent = Intent(this, TextActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }

        val colourButton: Button = findViewById<Button>(R.id.colour_button)
        colourButton.setOnClickListener {
            val intent = Intent(this, ColourActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }


        val readButton: Button = findViewById<Button>(R.id.read_button)
        readButton.setOnClickListener {
            val intent = Intent(this, ReadActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }

        val backButtonMainPage: ImageButton = findViewById<ImageButton>(R.id.backButtonMainPage)
        backButtonMainPage.setOnClickListener {
            val intent = Intent(this, UserSelectionActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }
    }
}