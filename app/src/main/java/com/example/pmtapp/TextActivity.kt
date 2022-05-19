package com.example.pmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.content.ContextCompat
import java.io.File

class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        val extras = intent.extras
        var user: String? = null

        if (extras != null) {
            user = extras.getString("user")
        }


        val backButtonTextPage: ImageButton = findViewById<ImageButton>(R.id.backButtonTextPage)
        backButtonTextPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{putExtra("user", user)}
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
        val submitButtonText: Button = findViewById<Button>(R.id.submitButtonText)
        submitButtonText.setOnClickListener {
            var textSizeToEnter = spinner.selectedItem
            val filePath: String = baseContext.filesDir.path.toString()
            var userDetailFile = File("$filePath/$user.txt")
            if (userDetailFile.exists()) {
                var usersDetails = userDetailFile.readLines()
                var userDetailsToWrite = ""
                var count = 0
                for (entry in usersDetails.withIndex()){
                    if (count == 0){
                        userDetailsToWrite += "$entry"
                    }
                    else if (count == 3){
                        userDetailsToWrite += "\n${textSizeToEnter.toString()}"
                    }
                    else{
                        userDetailsToWrite += "\n$entry"
                    }
                    count++
                }
                userDetailFile.writeText(userDetailsToWrite)
                Log.d("TAGD", "$userDetailsToWrite")

                val intent = Intent(this, TextActivity::class.java).apply{putExtra("user", user)}
                ContextCompat.startActivity(this, intent, null)
            }else{
                Log.d("TAG", "file not found")
            }
        }

        var textSizeToEnter = spinner.selectedItem
        val filePath: String = baseContext.filesDir.path.toString()
        var userDetailFile = File("$filePath/$user.txt")
        if (userDetailFile.exists()) {
            var usersDetails = userDetailFile.readLines()
            Log.d("TAG", "$usersDetails")
            if (usersDetails.isEmpty()){return}
            var textSize = usersDetails[3]
            var textSizeFloat : Float = textSize.toFloat()
            val defultText : TextView = findViewById<TextView>(R.id.preview_text_text_changer)
            defultText.textSize = textSizeFloat
        }else{
            Log.d("TAG", "file not found")
        }
    }
}