package com.edwinacubillos.micalculadora

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var resultado : String = ""

    val total: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun sumar(num1: Int, num2: Int) {
        val suma = num1 + num2
        resultado = "Suma: $suma"
    }

    fun restar(numero1: Int, numero2: Int) {
        val resta = numero1 - numero2
        resultado = resultado + "\nResta: $resta"
    }

    fun dividir(numero1: Int, numero2: Int) {
        val division = numero1 / numero2
        resultado = resultado + "\nDivision: $division"
    }

    fun multiplicar(numero1: Int, numero2: Int) {
        val multiplicacion = numero1 * numero2
        resultado = resultado + "\nMultiplicacion: $multiplicacion"
    }

    fun calcular(numero1: Int, numero2: Int, esSuma: Boolean, esResta: Boolean, esMultiplicacion: Boolean, esDivision: Boolean) {
        resultado = ""
        if (esSuma)
            sumar(numero1, numero2)
        if (esResta)
            restar(numero1, numero2)
        if (esMultiplicacion)
            multiplicar(numero1, numero2)
        if (esDivision)
            dividir(numero1, numero2)
        total.value = resultado
    }
}