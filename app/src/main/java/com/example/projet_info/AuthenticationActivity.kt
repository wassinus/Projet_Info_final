package com.example.projet_info

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Toast

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        val role = intent.getStringExtra("role")
        val usernameInput = findViewById<EditText>(R.id.username_input)
        val rootView = findViewById<ConstraintLayout>(R.id.root_view)
        val changeBackgroundButton = findViewById<Button>(R.id.change_background_button)
        val enterButton = findViewById<Button>(R.id.enter_button)

        enterButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            if (role == "Librarian") {
                if (!isValidUsername(username)) {
                    Toast.makeText(this, "Invalid username. Please enter the correct username for librarian.", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }}
            navigateToRoleSpecificActivity(role, username)
        }
        changeBackgroundButton.setOnClickListener {
            rootView.setBackgroundResource(Settings.getRandomBackground())
        }
    }

    private fun isValidUsername(username: String): Boolean {
        // Only 'Librarian1' is considered a valid username
        return username == "Librarian1"}

    private fun navigateToRoleSpecificActivity(role: String?, username: String) {
        val intent = when (role) {
            "Librarian" -> Intent(this, Librarian_activity::class.java)
            "Patron" -> Intent(this, Patron_activity::class.java)
            else -> throw IllegalStateException("Unknown role")
        }
        intent.putExtra("username", username)
        startActivity(intent)
    }
}