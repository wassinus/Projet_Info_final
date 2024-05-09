package com.example.projet_info

import java.util.Calendar

class Book(
    val title: String,
    val author: String,
    override var availability: Boolean,
    override var borrower: String? = null,
    override var dueDate: Calendar = Calendar.getInstance()
) : Borrowable {

    override fun borrow(username: String, itemType: String): Boolean {
        if (availability) {
            availability = false
            borrower = username
            dueDate = calculateDueDate()
            println("Book borrowed: $title by $borrower, due on ${dueDate.time}")
            return true
        } else {
            println("Book currently not available: $title")
            return false
        }
    }

    override fun returnItem() {
        availability = true
        println("Book returned: $title by $borrower")
        borrower = null
    }

    override fun checkAvailability(): Boolean {
        return availability
    }

    override fun calculateDueDate(): Calendar {
        val due = Calendar.getInstance()
        due.add(Calendar.DAY_OF_MONTH, 14)  // Set the due date to two weeks from today
        return due
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (author != other.author) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        return result
    }
}