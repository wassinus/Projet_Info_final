package com.example.projet_info

object LibrarianManager {
    private var username: String? = null

    fun setUsername(newUsername: String) {
        if (username == null) {
            username = newUsername
            println("Librarian username set to: $username")
        } else {
            println("Error: Username already set. Cannot modify.")
        }
    }
}
