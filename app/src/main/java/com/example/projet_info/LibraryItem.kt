package com.example.projet_info

interface LibraryItem {
    val title: String
    var available: Boolean
    data class Book(override val title: String, var author: String, override var available: Boolean) : LibraryItem

    data class Game(override val title: String, var developer: String, override var available: Boolean) : LibraryItem
}