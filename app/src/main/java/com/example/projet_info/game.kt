package com.example.projet_info

import java.util.Calendar

class Game(
    val name: String,
    override var availability: Boolean,
    override var borrower: String? = null,
    override var dueDate: Calendar = Calendar.getInstance()
) : Borrowable {

    override fun borrow(username: String, itemType: String): Boolean {
        if (availability) {
            availability = false
            borrower = username
            dueDate = calculateDueDate()
            println("Game borrowed: $name by $borrower, due on ${dueDate.time}")
            return true
        } else {
            println("Game currently not available: $name")
            return false
        }
    }

    override fun returnItem() {
        availability = true
        println("Game returned: $name by $borrower")
        borrower = null
    }

    override fun checkAvailability(): Boolean {
        return availability
    }

    override fun calculateDueDate(): Calendar {
        val due = Calendar.getInstance()
        due.add(Calendar.DAY_OF_MONTH, 7)  // Set the due date to one week from today
        return due
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Game

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result
        return result
    }
}