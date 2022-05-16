package com.example.pmtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.File

class UserCreation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_creation)
    }


    /*
    this function creates a new text file and saves the username, age and gender into it
    note: if the file is already there, this function will overwrite it. This will only happen if the user enters a name
    that is already taken
     */
    fun createNewProfile(userName: String, age: Int, gender: String) {

        val fileName = "$userName.txt"

        var file = File(fileName)

        // create a new file
        file.writeText("$userName,$age,$gender")

    }
}