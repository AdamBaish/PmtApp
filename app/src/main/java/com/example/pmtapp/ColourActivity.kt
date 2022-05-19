package com.example.pmtapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class ColourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colour)

        val extras = intent.extras
        var user: String? = null

        if (extras != null) {
            user = extras.getString("user")
        }

        val backButtonColourPage: ImageButton = findViewById<ImageButton>(R.id.backButtonColourPage)
        val imageView: ImageView = findViewById<ImageView>(R.id.imageView)
        val defaultButton: Button = findViewById<Button>(R.id.default_button)
        val redGreenColourBlind: Button = findViewById<Button>(R.id.RGbutton)
        val blueYellowCB: Button = findViewById(R.id.BYbutton)
        val helpButton: ImageButton = findViewById(R.id.helpButtonColourPage)

        backButtonColourPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply { putExtra("user", user) }
            ContextCompat.startActivity(this, intent, null)
        }

        defaultButton.setOnClickListener {
            imageView.clearColorFilter()
        }

        redGreenColourBlind.setOnClickListener {
            imageView.setColorFilter(0x79f9f9C4, PorterDuff.Mode.MULTIPLY);
        }

        blueYellowCB.setOnClickListener {
            imageView.setColorFilter(Color.argb(80, 125, 125, 125), PorterDuff.Mode.MULTIPLY)
        }

        helpButton.setOnClickListener {
            setContentView(R.layout.popupview)
            val popup_close_btn: Button = findViewById(R.id.popup_close_btn)
            popup_close_btn.setOnClickListener {
                val intent =
                    Intent(this, ColourActivity::class.java).apply { putExtra("user", user) }
                ContextCompat.startActivity(this, intent, null)
            }
        }
    }
}