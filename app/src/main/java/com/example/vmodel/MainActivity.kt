package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    lateinit var mViewModel: MainViewModel

    var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //logar(valor = "onCreate")

        initDados()
        //initContador()
        initClick()

        /*finalizarApp()*/
    }

    private fun finalizarApp() {
        finish()
    }

    override fun onStart(){
        //logar(valor = "onStart")
        super.onStart()
    }

    override fun onResume() {
        //logar(valor = "onResume")
        super.onResume()
    }

    override fun onPause() {
        //logar(valor = "onPause")
        super.onPause()
    }

    override fun onStop() {
        //logar(valor = "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        //logar(valor = "onDestroy")
        super.onDestroy()
    }

    /*private fun logar(tag: String = "Ciclo de Vida", valor: String){
        Log.d(tag, valor)
    }*/



    private fun initClick(){
        btnDados.setOnClickListener{
            contador++
            mViewModel.Contador()
            //initContador()
        }

        btnMostrar.setOnClickListener{
            //Toast.makeText(this, "Valor Contador: ${contador.toString()}", Toast.LENGTH_SHORT).show()
            //finalizarApp()
            Toast.makeText(applicationContext, "Valor Contador: ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)

        mViewModel.mContador.observe(this, Observer {  valor ->
            txtContador.setText(valor)

        })
    }

    /*private fun initContador(){
        txtContador.setText(contador.toString())
    }*/


}