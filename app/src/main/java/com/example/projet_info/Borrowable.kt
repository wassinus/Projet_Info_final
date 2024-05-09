package com.example.projet_info

import java.util.Calendar

interface Borrowable {
    var availability: Boolean
    var borrower: String?
    var dueDate: Calendar

    fun borrow(username: String, itemType: String): Boolean
    fun returnItem()
    fun checkAvailability(): Boolean
    fun calculateDueDate(): Calendar
}