package com.example.motivacional.util

import android.content.Context
import android.content.SharedPreferences

class DadosCompartilhados (contexto: Context) {

    private val mCompartilhamento: SharedPreferences = contexto.getSharedPreferences("motivacional", Context.MODE_PRIVATE)

    fun armazenaValor(chave: String, valor: String){
        mCompartilhamento.edit().putString(chave, valor).apply()
    }

    fun buscaValor (chave: String): String{
        return mCompartilhamento.getString(chave, "")
    }

}