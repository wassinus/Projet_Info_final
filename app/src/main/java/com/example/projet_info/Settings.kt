package com.example.projet_info

import kotlin.random.Random

object Settings {
    private val backgrounds = arrayOf(
        R.drawable.background1,
        R.drawable.background2,
        R.drawable.background3,
    )

    fun getRandomBackground(): Int {
        return backgrounds[Random.nextInt(backgrounds.size)]
    }
}