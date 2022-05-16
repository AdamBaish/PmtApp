package com.example.pmtapp

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.content.ContextCompat
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class ColourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colour)

        val backButtonColourPage: ImageButton = findViewById<ImageButton>(R.id.backButtonColourPage)
        backButtonColourPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }

        val redGreenColourBlind: Button = findViewById<Button>(R.id.RGbutton)
        val imageView: ImageView = findViewById<ImageView>(R.id.imageView)
        redGreenColourBlind.setOnClickListener {
            imageView.setColorFilter(0x76ffffff, PorterDuff.Mode.MULTIPLY );
        }
    }
}