package com.example.pmtapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class UserCreation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_creation)

        val createButton: Button = findViewById<Button>(R.id.createButton)
        createButton.setOnClickListener {
            //retrieve the username
            val editTextUserName: EditText = findViewById<EditText>(R.id.editTextUserName)
            var userName = editTextUserName.text.toString()

            //retrieve the gender
            val editTextGender: EditText = findViewById<EditText>(R.id.editTextGender)
            var gender = editTextGender.text.toString()

            //retrieve the age
            val editTextAge: EditText = findViewById<EditText>(R.id.editTextAge)
            var ageString = editTextAge.text.toString()
            var age = ageString.toInt()

            //create the new profile by calling the function
            var success = createNewProfile(userName,age,gender)
            if (success){
                //pass back to user selection
                val intent = Intent(this, UserSelectionActivity::class.java).apply{}
                ContextCompat.startActivity(this, intent, null)
            }else{
                //inform the user there has been an error
                Toast.makeText(baseContext, "error, please try again with a new user name", Toast.LENGTH_SHORT).show()
            }
        }
    }


    /*
    this function creates a new text file and saves the username, age and gender into it
    note: if the file is already there, this function will overwrite it. This will only happen if the user enters a name
    that is already taken
     */
    private fun createNewProfile(userName: String, age: Int, gender: String): Boolean {
        try {
            val fileOutputStream: FileOutputStream = openFileOutput("$userName.txt", Context.MODE_PRIVATE)
            val outputWriter = OutputStreamWriter(fileOutputStream)
            outputWriter.write("$userName,$age,$gender")
            outputWriter.close()
            //display file saved message
            Toast.makeText(baseContext, "File saved successfully!", Toast.LENGTH_SHORT).show()
            return true
        }
        catch (e: Exception) {
            e.printStackTrace()
            return false
        }

    }
}