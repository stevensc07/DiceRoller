package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
var score1 = 0
var score2=0
var num=0
var sw=true
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // aquí cargamos el layout
        setContentView(R.layout.activity_main)



    }

    private fun lanzarDado() {
        // instanciamos un dado con 6 lados
        val dado = Dado(6)
        val dado2 = Dado(6)
        val valorDado = dado.lanzar()
        val valorDado2 = dado2.lanzar()
        print(valorDado)
        print(valorDado2)
        num=valorDado + valorDado2


        // el método findById permite conectar una instancia de TextView con nuestra variable
        // el Id es el mismo que declaramos en el Layout
        val imagenDado: ImageView = findViewById(R.id.imageView)
        val imagenDado2: ImageView = findViewById(R.id.imageView4)
        // dependiendo del valor del dado cargamos el recurso
        when (valorDado) {
            1 -> imagenDado.setImageResource(R.drawable.dice_1)
            2 -> imagenDado.setImageResource(R.drawable.dice_2)
            3 -> imagenDado.setImageResource(R.drawable.dice_3)
            4 -> imagenDado.setImageResource(R.drawable.dice_4)
            5 -> imagenDado.setImageResource(R.drawable.dice_5)
            6 -> imagenDado.setImageResource(R.drawable.dice_6)
        }
        when (valorDado2) {
            1 -> imagenDado2.setImageResource(R.drawable.dice_1)
            2 -> imagenDado2.setImageResource(R.drawable.dice_2)
            3 -> imagenDado2.setImageResource(R.drawable.dice_3)
            4 -> imagenDado2.setImageResource(R.drawable.dice_4)
            5 -> imagenDado2.setImageResource(R.drawable.dice_5)
            6 -> imagenDado2.setImageResource(R.drawable.dice_6)
        }
    }


    // método que se llama cada vez que se presiona el botón
    fun onClickLanzarDado(view: View) {
        // Mensaje visible por el usuario en la pantalla
        Toast.makeText(this, "Dado lanzado, turno del siguiente jugador" , Toast.LENGTH_LONG).show()
        // Mensaje para tiempo de desarrollo, solo visible en la consola de
        // logcat en AndroidStudio
        Log.d("AplicacionDados", "Dado lanzado")
        lanzarDado();

        if (sw==true) {
            // El código de este bloque se ejecuta si se cumple la condición
            score1 += num
            val tex : TextView = findViewById(R.id.text_view)
            tex.text= score1.toString()
            sw=false
        } else {
            score2 += num
            val tex2: TextView = findViewById(R.id.text_view2)
            tex2.text= score2.toString()
            sw=true
        }


    }


}