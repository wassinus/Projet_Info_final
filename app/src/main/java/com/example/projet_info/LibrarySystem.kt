package com.example.projet_info

class LibrarySystem(private val database: Database) {

    fun addBook(book: Book) {
        Database.saveBook(book)
        println("LibrarySystem: Book added - ${book.title}")
    }

    fun removeBook(book: Book) {
        Database.deleteBook(book)
        println("LibrarySystem: Book removed - ${book.title}")
    }
}