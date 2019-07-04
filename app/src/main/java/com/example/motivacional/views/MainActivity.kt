package com.example.motivacional.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivacional.R
import com.example.motivacional.mock.Mock
import com.example.motivacional.util.ConstantesMotivacional
import com.example.motivacional.util.DadosCompartilhados
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mFiltro: Int = ConstantesMotivacional.FILTRO_FRASE.TUDO
    private lateinit var mDadosCompartilhados: DadosCompartilhados
    private val mMock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDadosCompartilhados = DadosCompartilhados(this)

        manipulaEventos()

        controlaFiltro(R.id.imageInfinito)
        atualizaFrase()
        verificaUsuario()
    }

    private fun verificaUsuario() {
        textNomeUsuario.text = "Olá, ${mDadosCompartilhados.buscaValor(ConstantesMotivacional.CHAVE.NOME_USUARIO)}!"
    }

    override fun onClick(view: View) {
        val id = view.id

        val listaIds = listOf(R.id.imageInfinito, R.id.imageSol, R.id.imageFeliz)
        if (id in listaIds) {
            controlaFiltro(id)
        } else if (id == R.id.buttonNovaFrase) {
            atualizaFrase()
        }

    }

    private fun controlaFiltro(id: Int) {

        imageInfinito.setImageResource(R.drawable.ic_infinito_nao_selecionado)
        imageSol.setImageResource(R.drawable.ic_sol_nao_selecionado)
        imageFeliz.setImageResource(R.drawable.ic_feliz_nao_selecionado)

        if (id == R.id.imageInfinito) {
            mFiltro = ConstantesMotivacional.FILTRO_FRASE.TUDO
            imageInfinito.setImageResource(R.drawable.ic_infinito_selecionado)
        } else if (id == R.id.imageSol) {
            mFiltro = ConstantesMotivacional.FILTRO_FRASE.BOMDIA
            imageSol.setImageResource(R.drawable.ic_sol_selecionado)
        } else {
            mFiltro = ConstantesMotivacional.FILTRO_FRASE.FELIZ
            imageFeliz.setImageResource(R.drawable.ic_feliz_selecionado)
        }
    }

    private fun atualizaFrase() {
        textFrase.text = mMock.buscaFrase(mFiltro)
    }

    private fun manipulaEventos() {
        imageInfinito.setOnClickListener(this)
        imageSol.setOnClickListener(this)
        imageFeliz.setOnClickListener(this)
        buttonNovaFrase.setOnClickListener(this)
    }
}
