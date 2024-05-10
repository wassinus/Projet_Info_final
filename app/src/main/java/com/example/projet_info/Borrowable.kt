package com.example.projet_info

import java.util.Calendar

interface Borrowable {
    var availability: Boolean
    var borrower: String?
    var dueDate: Calendar

    fun borrow(username: String, itemType: String): Boolean
    fun returnItem() {
        this.availability = true
        // Update the database or whatever storage you're using
    }

    fun checkAvailability(): Boolean
    fun calculateDueDate(): Calendar
}