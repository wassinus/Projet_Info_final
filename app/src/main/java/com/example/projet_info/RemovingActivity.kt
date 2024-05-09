package com.example.projet_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RemovingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_removing)

        val title = findViewById<EditText>(R.id.removed_book_title)
        val author = findViewById<EditText>(R.id.removed_book_author)
        val removebookButton = findViewById<Button>(R.id.confirm_button3)

        removebookButton.setOnClickListener {
            val titleText = title.text.toString().trim()
            val authorText = author.text.toString().trim()
            if (titleText.isNotEmpty() && authorText.isNotEmpty()) {
                Database.deleteBook(Book(titleText, authorText, availability = false))
                title.text.clear()
                author.text.clear()
            }
            Toast.makeText(this, "Book successfully deleted", Toast.LENGTH_LONG).show()
        }

        val gamename = findViewById<EditText>(R.id.removed_game_name)
        val removegameButton = findViewById<Button>(R.id.confirm_button4)

        removegameButton.setOnClickListener {
            val gamenameText = gamename.text.toString().trim()
            if (gamenameText.isNotEmpty()) {
                Database.deleteGame(Game(gamenameText, availability = false))
                gamename.text.clear()
            }
            Toast.makeText(this, "Game successfully deleted", Toast.LENGTH_LONG).show()
        }
    }
}