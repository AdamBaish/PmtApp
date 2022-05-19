package com.example.pmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.core.content.ContextCompat

class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        val backButtonTextPage: ImageButton = findViewById<ImageButton>(R.id.backButtonTextPage)
        backButtonTextPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }

        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.spinnerArray,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter
        }
    }
}