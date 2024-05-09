package com.example.projet_info

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLibrarian = findViewById<Button>(R.id.btnLibrarian)
        val btnPatron = findViewById<Button>(R.id.btnPatron)

        btnLibrarian.setOnClickListener {
            startAuthentication("Librarian")
        }

        btnPatron.setOnClickListener {
            startAuthentication("Patron")
        }
    }

    private fun startAuthentication(role: String) {
        val intent = Intent(this, AuthenticationActivity::class.java).apply {
            putExtra("role", role)}
        startActivity(intent)
    }
}