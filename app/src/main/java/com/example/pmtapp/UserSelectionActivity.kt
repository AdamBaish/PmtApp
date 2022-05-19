package com.example.pmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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

        val resetbutton: Button = findViewById<Button>(R.id.resetButton)
        resetbutton.setOnClickListener {
            val filePath: String = baseContext.filesDir.path.toString()
            var usersFile = File("$filePath/users.txt")
            usersFile.createNewFile()
            usersFile.writeText("")
            val intent = Intent(this, UserSelectionActivity::class.java).apply{}
            ContextCompat.startActivity(this, intent, null)
        }

        val filePath: String = baseContext.filesDir.path.toString().toString() + "/users.txt"
        var file = File(filePath)
        if (file.exists()) {
            var users = file.readLines()
            if (users.isEmpty()){return}
            var usersList: List<String> = users[0].split(",")
            Log.d("TAG1", "$users")
            Log.d("TAG2", "$usersList")
            var count = 0
            for (user in usersList){
                count++
                if (user != ""){
                    if (count == 1){
                        val UserButton1: Button = findViewById<Button>(R.id.UserButton1)
                        Log.d("TAGName", "$user")
                        UserButton1.setOnClickListener {
                            val intent = Intent(this, MainActivity::class.java).apply{putExtra("user", user)}
                            ContextCompat.startActivity(this, intent, null)
                        }
                        UserButton1.text = user
                        UserButton1.visibility = View.VISIBLE
                    }
                    if (count == 2){
                        val UserButton2: Button = findViewById<Button>(R.id.UserButton2)
                        UserButton2.setOnClickListener {
                            val intent = Intent(this, MainActivity::class.java).apply{putExtra("user", user)}
                            ContextCompat.startActivity(this, intent, null)
                        }
                        UserButton2.text = user
                        UserButton2.visibility = View.VISIBLE
                    }
                    if (count == 3){
                        val UserButton3: Button = findViewById<Button>(R.id.UserButton3)
                        var userName3=UserButton3.text
                        UserButton3.setOnClickListener {
                            val intent = Intent(this, MainActivity::class.java).apply{putExtra("user", user)}
                            ContextCompat.startActivity(this, intent, null)
                        }
                        UserButton3.text = user
                        UserButton3.visibility = View.VISIBLE
                    }

                }
            }
        }else{
            Log.d("TAG", "file not found")
        }
    }
}