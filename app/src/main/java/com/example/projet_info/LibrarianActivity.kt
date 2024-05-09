package com.example.projet_info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class Librarian_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_librarian)

        val addButton = findViewById<Button>(R.id.btn_additem)
        addButton.setOnClickListener {
            val intent = Intent(this, AddingActivity::class.java)
            startActivity(intent)
        }

        val removeButton = findViewById<Button>(R.id.btn_removeitem)
        removeButton.setOnClickListener {
            val intent = Intent(this, RemovingActivity::class.java)
            startActivity(intent)
        }
    }

}