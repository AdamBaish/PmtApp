package com.example.pmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.*

class ReadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        val extras = intent.extras
        var user: String? = null

        if (extras != null) {
            user = extras.getString("user")
        }

        val backButtonReadPage: ImageButton = findViewById<ImageButton>(R.id.backButtonReadPage)
        backButtonReadPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{ putExtra("user", user) }
            ContextCompat.startActivity(this, intent, null)
        }

        lateinit var tts : TextToSpeech

        val readBtn: Button = findViewById(R.id.readAloudBtn)
        val readText: TextView = findViewById(R.id.preview_text_read)
        readBtn.setOnClickListener{
            tts = TextToSpeech(this, TextToSpeech.OnInitListener {
                if (it == TextToSpeech.SUCCESS) {
                    tts.language = Locale.UK
                    tts.setSpeechRate(1.0f)
                    tts.speak(readText.text.toString(), TextToSpeech.QUEUE_FLUSH, null, "")
                }
            })
        }

        val helpbtn: ImageButton = findViewById(R.id.helpButtonReadPage)
        helpbtn.setOnClickListener{
            setContentView(R.layout.readpopupview)
            val popupbtn: Button = findViewById(R.id.popup_close_btn_read)
            popupbtn.setOnClickListener{
                val intent = Intent(this, ReadActivity::class.java).apply{ putExtra("user", user) }
                ContextCompat.startActivity(this, intent, null)
            }
        }
    }

}