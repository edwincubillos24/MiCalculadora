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
}