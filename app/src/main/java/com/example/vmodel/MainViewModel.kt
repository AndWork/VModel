package com.example.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var contador: Int = 0
    val mContador = MutableLiveData<String>().apply { value = contador.toString() }

    private fun setmContador(){
        mContador.value = contador.toString()
    }

    private fun validaContador() {
        if(contador > 5){
            contador = 0
        }

        setmContador()
    }

    fun Contador(){
        validaContador()
    }

}