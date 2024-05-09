package com.example.projet_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class AddingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding)


        val title = findViewById<EditText>(R.id.added_book_title)
        val author = findViewById<EditText>(R.id.added_book_author)
        val addbookButton = findViewById<Button>(R.id.confirm_button1)

        addbookButton.setOnClickListener {
            val titleText = title.text.toString().trim()
            val authorText = author.text.toString().trim()
            if (titleText.isNotEmpty() && authorText.isNotEmpty()) {
                Database.saveBook(Book(titleText, authorText, availability = true))
                title.text.clear()
                author.text.clear()
            }
            Toast.makeText(this, "Book successfully added", Toast.LENGTH_LONG).show()
        }

        val gamename = findViewById<EditText>(R.id.added_game_name)
        val addgameButton = findViewById<Button>(R.id.confirm_button2)

        addgameButton.setOnClickListener {
            val gamenameText = gamename.text.toString().trim()
            if (gamenameText.isNotEmpty()) {
                Database.saveGame(Game(gamenameText, availability = true))
                gamename.text.clear()
            }
            Toast.makeText(this, "Game successfully added", Toast.LENGTH_LONG).show()
        }
    }
}