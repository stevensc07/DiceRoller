package com.example.diceroller

// Nuestra primera clase
class Dado(val numLados: Int) {

    // método para devolver un aleatorio entre 1 u 6
    fun lanzar() : Int {
        return (1..numLados).random();
    }
}