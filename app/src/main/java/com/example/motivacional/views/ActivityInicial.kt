package com.example.motivacional.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivacional.R
import com.example.motivacional.util.ConstantesMotivacional
import com.example.motivacional.util.DadosCompartilhados
import kotlinx.android.synthetic.main.activity_inicial.*

class ActivityInicial : AppCompatActivity(), View.OnClickListener {

    //lateinit define q a variável vai ser inicializada tardiamente
    private lateinit var mCompartilhamento: DadosCompartilhados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        mCompartilhamento = DadosCompartilhados(this)

        buttonSalvar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSalvar) {
            salvar()
        }
    }

    private fun salvar() {
        val nome: String = editNome.text.toString()
        if (nome == "") {
            Toast.makeText(this, getString(R.string.Informe_seu_nome), Toast.LENGTH_LONG).show()
        } else {
            mCompartilhamento.armazenaValor(ConstantesMotivacional.CHAVE.NOME_USUARIO, nome)

            val intencao: Intent = Intent(this, MainActivity::class.java)
            startActivity(intencao)

            //impede que seja possivel voltar a essa activity. Se apertar o botão de voltar, fecha o app
            //finish()
        }
    }

}
