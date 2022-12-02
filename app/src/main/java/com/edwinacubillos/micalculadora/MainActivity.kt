package com.edwinacubillos.micalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.edwinacubillos.micalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContentView(view)

        val totalObserver = Observer<Int> { total ->
            mostrarResultado(total)
        }

        mainViewModel.total.observe(this, totalObserver)

        mainBinding.sumarButton.setOnClickListener {
            val numero1 = mainBinding.numeroUnoEditText.text.toString().toInt()
            val numero2 = mainBinding.numeroDosEditText.text.toString().toInt()
            mainViewModel.sumar(numero1, numero2)
        }

        mainBinding.restarButton.setOnClickListener {
            val numero1 = mainBinding.numeroUnoEditText.text.toString().toInt()
            val numero2 = mainBinding.numeroDosEditText.text.toString().toInt()
            mainViewModel.restar(numero1, numero2)
        }

        mainBinding.multiplicarButton.setOnClickListener {
            val numero1 = mainBinding.numeroUnoEditText.text.toString().toInt()
            val numero2 = mainBinding.numeroDosEditText.text.toString().toInt()
            mainViewModel.multiplicar(numero1, numero2)
        }

        mainBinding.dividirButton.setOnClickListener {
            val numero1 = mainBinding.numeroUnoEditText.text.toString().toInt()
            val numero2 = mainBinding.numeroDosEditText.text.toString().toInt()
            mainViewModel.dividir(numero1, numero2)
        }
    }

    fun mostrarResultado(total: Int){
        mainBinding.resultadoTextView.text = total.toString()
    }
}