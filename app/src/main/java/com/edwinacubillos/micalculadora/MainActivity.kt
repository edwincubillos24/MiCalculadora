package com.edwinacubillos.micalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edwinacubillos.micalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.sumarButton.setOnClickListener {
            val numero1 = mainBinding.numeroUnoEditText.text.toString().toInt()
            val numero2 = mainBinding.numeroDosEditText.text.toString().toInt()
            sumar(numero1, numero2)
        }

        mainBinding.restarButton.setOnClickListener {
            val numero1 = mainBinding.numeroUnoEditText.text.toString().toInt()
            val numero2 = mainBinding.numeroDosEditText.text.toString().toInt()
            restar(numero1, numero2)
        }

        mainBinding.multiplicarButton.setOnClickListener {
            val numero1 = mainBinding.numeroUnoEditText.text.toString().toInt()
            val numero2 = mainBinding.numeroDosEditText.text.toString().toInt()
            multiplicar(numero1, numero2)
        }

        mainBinding.dividirButton.setOnClickListener {
            val numero1 = mainBinding.numeroUnoEditText.text.toString().toInt()
            val numero2 = mainBinding.numeroDosEditText.text.toString().toInt()
            dividir(numero1, numero2)
        }
    }

    private fun dividir(numero1: Int, numero2: Int) {
        val total = numero1 / numero2
        mostrarResultado(total)
    }

    private fun multiplicar(numero1: Int, numero2: Int) {
        val total = numero1 * numero2
        mostrarResultado(total)
    }

    private fun restar(numero1: Int, numero2: Int) {
        val total = numero1 - numero2
        mostrarResultado(total)
    }

    fun sumar(num1: Int, num2:Int){
        val total = num1 + num2
        mostrarResultado(total)
    }

    fun mostrarResultado(total: Int){
        mainBinding.resultadoTextView.text = total.toString()
    }
}