package com.example.motivacional.mock

import com.example.motivacional.util.ConstantesMotivacional
import java.util.*

class Frase(val descricao: String, val categoria: Int)

fun Int.meuRandom(): Int = Random().nextInt(this)

class Mock {

    private val TUDO = ConstantesMotivacional.FILTRO_FRASE.TUDO
    private val BOMDIA = ConstantesMotivacional.FILTRO_FRASE.BOMDIA
    private val FELIZ = ConstantesMotivacional.FILTRO_FRASE.FELIZ

    private val mListaFrases: List<Frase> = listOf(
        Frase("Não sabendo que era impossível, foi lá e fez.", FELIZ),
        Frase("Você não é derrotado quando perde, você é derrotado quando desiste!", FELIZ),
        Frase("Quando está mais escuro, vemos mais estrelas!", FELIZ),
        Frase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", FELIZ),
        Frase("Não pare quando estiver cansado, pare quando tiver terminado.", FELIZ),
        Frase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", FELIZ),
        Frase("A melhor maneira de prever o futuro é inventá-lo.", BOMDIA),
        Frase("Você perde todas as chances que você não aproveita.", BOMDIA),
        Frase("Fracasso é o condimento que dá sabor ao sucesso.", BOMDIA),
        Frase("Enquanto não estivermos comprometidos, haverá hesitação!", BOMDIA),
        Frase("Se você não sabe onde quer ir, qualquer caminho serve.", BOMDIA),
        Frase("Se você acredita, faz toda a diferença.", BOMDIA),
        Frase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", BOMDIA)
    )

    fun buscaFrase(idFiltro: Int): String {

        val listaFrasesFiltradas = mListaFrases.filter { it.categoria == idFiltro || idFiltro == TUDO }

        val idAleatorio = (listaFrasesFiltradas.size).meuRandom()

        return listaFrasesFiltradas[idAleatorio].descricao
    }
}