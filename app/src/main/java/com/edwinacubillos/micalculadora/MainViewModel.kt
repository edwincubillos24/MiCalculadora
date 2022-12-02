package com.edwinacubillos.micalculadora

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val total : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun sumar(num1: Int, num2:Int){
        total.value = num1 + num2
    }

    fun dividir(numero1: Int, numero2: Int) {
        total.value = numero1 / numero2
    }

    fun multiplicar(numero1: Int, numero2: Int) {
        total.value = numero1 * numero2
    }

    fun restar(numero1: Int, numero2: Int) {
        total.value = numero1 - numero2
    }

    fun calcular(numero1: Int, numero2: Int, esSuma: Boolean, esResta: Boolean, esMultiplicacion: Boolean, esDivision: Boolean) {
        if (esSuma)
            sumar(numero1, numero2)
        else if (esResta)
            restar(numero1, numero2)
        else if (esMultiplicacion)
            multiplicar(numero1, numero2)
        else dividir(numero1, numero2)
    }
}