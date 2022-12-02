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

        mainBinding.calcularButton.setOnClickListener {
            val numero1 = mainBinding.numeroUnoEditText.text.toString().toInt()
            val numero2 = mainBinding.numeroDosEditText.text.toString().toInt()
            val esSuma = mainBinding.sumarRadioButton.isChecked
            val esResta = mainBinding.restarRadioButton.isChecked
            val esMultiplicacion = mainBinding.multiplicarRadioButton.isChecked
            val esDivision = mainBinding.dividirRadioButton.isChecked
            mainViewModel.calcular(numero1, numero2, esSuma, esResta, esMultiplicacion, esDivision)
        }
    }

    fun mostrarResultado(total: Int){
        mainBinding.resultadoTextView.text = total.toString()
    }
}