package com.example.pmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text_button: Button = findViewById<Button>(R.id.text_button)
        text_button.setOnClickListener {
            val intent = Intent(this, TextActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }
    }
}