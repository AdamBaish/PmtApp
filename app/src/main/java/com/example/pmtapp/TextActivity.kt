package com.example.pmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

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

        val helpButton: ImageButton = findViewById(R.id.helpButtonTextPage)
        helpButton.setOnClickListener {
            setContentView(R.layout.textsizepopup)
            val popupclosebtn: Button = findViewById(R.id.popup_close_btn_text)
            popupclosebtn.setOnClickListener{
                val intent = Intent(this, TextActivity::class.java).apply{}
                ContextCompat.startActivity(this, intent, null)
            }
        }
    }


}