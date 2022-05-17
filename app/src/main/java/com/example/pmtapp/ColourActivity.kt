package com.example.pmtapp

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class ColourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colour)

        val backButtonColourPage: ImageButton = findViewById<ImageButton>(R.id.backButtonColourPage)
        val imageView: ImageView = findViewById<ImageView>(R.id.imageView)
        val defaultButton: Button = findViewById<Button>(R.id.default_button)
        val redGreenColourBlind: Button = findViewById<Button>(R.id.RGbutton)
        val blueYellowCB: Button = findViewById(R.id.BYbutton)
        val helpButton: ImageButton = findViewById(R.id.helpButtonColourPage)

        backButtonColourPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }

        defaultButton.setOnClickListener{
            imageView.clearColorFilter()
        }

        redGreenColourBlind.setOnClickListener {
            imageView.setColorFilter(0x79f9f9C4, PorterDuff.Mode.MULTIPLY );
        }

       blueYellowCB.setOnClickListener{
           imageView.setColorFilter(Color.rgb(125, 125, 125), PorterDuff.Mode.MULTIPLY)
       }

        helpButton.setOnClickListener{

        }

    }
}