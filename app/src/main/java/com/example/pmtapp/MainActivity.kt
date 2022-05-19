package com.example.pmtapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val extras = intent.extras
        var userName: String? = null

        if (extras != null) {
            userName = extras.getString("user")
        }

        val textButton: Button = findViewById<Button>(R.id.text_button)
        textButton.setOnClickListener {
            val intent = Intent(this, TextActivity::class.java).apply{putExtra("user", userName)}
            ContextCompat.startActivity(this, intent, null)
        }

        val colourButton: Button = findViewById<Button>(R.id.colour_button)
        colourButton.setOnClickListener {
            val intent = Intent(this, ColourActivity::class.java).apply{putExtra("user", userName)}
            ContextCompat.startActivity(this, intent, null)
        }


        val readButton: Button = findViewById<Button>(R.id.read_button)
        readButton.setOnClickListener {
            val intent = Intent(this, ReadActivity::class.java).apply{putExtra("user", userName)}
            ContextCompat.startActivity(this, intent, null)
        }

        val backButtonMainPage: ImageButton = findViewById<ImageButton>(R.id.backButtonMainPage)
        backButtonMainPage.setOnClickListener {
            val intent = Intent(this, UserSelectionActivity::class.java).apply{putExtra("user", userName)}
            ContextCompat.startActivity(this, intent, null)
        }

        val filePath: String = baseContext.filesDir.path.toString()
        var userDetailFile = File("$filePath/$userName.txt")
        if (userDetailFile.exists()) {
            var usersDetails = userDetailFile.readLines()
            if (usersDetails.isEmpty()){return}
            var textSize = usersDetails[3]
            var textSizeFloat : Float = textSize.toFloat()
            val defultText : TextView = findViewById<TextView>(R.id.preview_text)
            defultText.textSize = textSizeFloat
        }else{
            Log.d("TAG", "file not found")
        }
    }
}