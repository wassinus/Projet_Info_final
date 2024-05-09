package com.example.projet_info

class Database {

    companion object {
        private val books = mutableListOf<Book>()
        private val games = mutableListOf<Game>()
        private val borrowedItems = mutableListOf<Any>()

        fun saveBook(book: Book) {
            books.add(book)
            println("Database: Book saved - ${book.title}")
        }


        fun deleteBook(book: Book) {
            if (books.remove(book)) {
                println("Database: Book deleted - ${book.title}")
            } else {
                println("Database: Book not found - ${book.title}")
            }
        }

        fun saveGame(game: Game) {
            games.add(game)
            println("Database: Game saved - ${game.name}")
        }

        fun deleteGame(game: Game) {
            return if (games.remove(game)) {
                println("Database: Book deleted - ${game.name}")
            } else {
                println("Database: Book not found - ${game.name}")
            }
        }

        fun getAllBooks(): List<Book> = books.toList()
        fun getAllGames(): List<Game> = games.toList()
        fun getBorrowedItems() = borrowedItems.toList()
    }
}