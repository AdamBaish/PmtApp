package com.example.pmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.ContextCompat
import java.io.File

class UserSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_selection)


        val newUserButton: Button = findViewById<Button>(R.id.newUserButton)
        newUserButton.setOnClickListener {
            val intent = Intent(this, UserCreation::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }

        val tempbutton: Button = findViewById<Button>(R.id.tempbutton)
        tempbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }

        val filePath: String = baseContext.filesDir.path.toString().toString() + "/users.txt"
        var file = File(filePath)
        if (file.exists()) {
            var users = file.readLines()
            Log.d("TAG", "$users")
        }else{
            Log.d("TAG", "file not found")
        }
    }
}