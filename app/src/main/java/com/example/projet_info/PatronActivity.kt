package com.example.projet_info

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Patron_activity : AppCompatActivity(), OnItemBorrowedListener {

    private lateinit var username: String // Declare the username variable
    private val CHANNEL_ID = "channel_id_example_01"
    private val notificationId = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patron)

        username = intent.getStringExtra("username") ?: "DefaultUser"  // Default username if none is provided

        setupRecyclerView()
    }


    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Assuming you have methods in Database to get all books and games
        val items = mutableListOf<Any>().apply {
            addAll(Database.getAllBooks())
            addAll(Database.getAllGames())
        }

        val adapter = BookGameAdapter(items, this, username)
        recyclerView.adapter = adapter
    }

    override fun onItemBorrowed(item: Any) {
        // Here, you can handle the event when an item is borrowed.
        // For example, showing a toast message.
        Toast.makeText(this, "Item borrowed!", Toast.LENGTH_SHORT).show()
    }
}