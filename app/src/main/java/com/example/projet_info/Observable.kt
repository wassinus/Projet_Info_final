package com.example.projet_info

interface Observable {
    val observers: MutableList<Observer>

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyObservers(arg: Any? = null) {
        observers.forEach { observer ->
            observer.update(this, arg)
        }
    }
}