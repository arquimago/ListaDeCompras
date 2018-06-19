package net.alvesnet.arquimago.listadecompras

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val nomeBD = "compras"
val versaoBD = 4

class BDCore(context: Context): SQLiteOpenHelper(context, nomeBD, null, versaoBD){

    override fun onCreate(bd: SQLiteDatabase) {
        bd.run {
            execSQL("CREATE TABLE itens(_id integer primary key autoincrement, nome text not null, categoria integer not null DEFAULT 0, comprar integer not null DEFAULT 0)")
            execSQL("CREATE TABLE categorias(_id integer primary key autoincrement, nomeCategoria not null)")
        }
        popularItens(bd)
        popularCategorias(bd)
    }

    override fun onUpgrade(bd: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        bd.run{
            execSQL("drop table itens")
            execSQL("drop table categorias")
        }
            onCreate(bd)
    }

    private fun inserir(item: ItemDaLista, bd: SQLiteDatabase){
        val valores = ContentValues()
        valores.put("nome", item.nome)
        valores.put("categoria", item.categoria)
        valores.put("comprar", if(item.comprar) 0 else 1)

        bd.insert("itens",null,valores)
    }

    private fun popularCategorias(bd: SQLiteDatabase){
        val valores = ContentValues()
        val tabTitles = arrayOf("Temperos", "Cozinhar", "Café da Manhã", "Diversos", "Feira", "Limpeza", "Higiene", "Bebidas")
        for(categoria  in tabTitles){
            valores.put("nomeCategoria", categoria)
            bd.insert("categorias",null,valores)
        }
    }

    private fun popularItens(bd: SQLiteDatabase){
        val item = ItemDaLista()
        item.comprar = false
        item.quantidade = 0

        item.nome = "Canela"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Pimenta do Reino"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Molho de Pimenta"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Ervas Frescas"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Manjericão"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Orégano"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Azeite de Oliva"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Queijo Ralado"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Mostarda"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Catchup"
        item.categoria = 1
        inserir(item, bd)

        item.nome = "Sal"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Arroz"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Feijão"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Macarrão"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Farinha de Trigo"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Farinha de Mandioca"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Fermento"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Óleo vegetal"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Creme de Leite"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Leite Condesado"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Caldo Pronto"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Molho de Tomate"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Extrato de Tomate"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Carne"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Peixe"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Frango"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Carne Moída"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Kibe"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Nuggets"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Almondegas"
        item.categoria = 2
        inserir(item, bd)

        item.nome = "Café em Pó"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Café Solúvel"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Café em capsulas"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Achocolatado"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Leite Caixinha"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Leite em Pó"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Iogurte"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Manteiga"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Requeijão Cremoso"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Geléia"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Adoçante"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Açúcar"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Cereal Matinal"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Barrade Cereais"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Granola"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Pão"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Biscoito Doce"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Biscoito Salgado"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Queijo"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Presunto"
        item.categoria = 3
        inserir(item, bd)

        item.nome = "Filtro de Café"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Guardanapos"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Papel Toalha"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Pano de Prato"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Filme de PVC"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Papel Alumínio"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Palito de Dente"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Sacos para Embalar"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Lâmpada"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Velas"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Pilhas"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Fósforos"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Prendedor de Roupa"
        item.categoria = 4
        inserir(item, bd)

        item.nome = "Maçã"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Laranja"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Banana Prata"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Banana da Terra"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Pera"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Limão"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Uva"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Batata"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Cenoura"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Beterraba"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Alface"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Tomate"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Rúcula"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Alho"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Cebola"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Coentro"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Cebolinha"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Abóbora"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Melancia"
        item.categoria = 5
        inserir(item, bd)

        item.nome = "Detergente"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Esponja"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Palha de Aço"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Limpador Multiuso"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Sabão p/ Lava-Louça"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Sabão em Barra"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Sabão em Pó"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Sabão Líquido"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Amaciante"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Água Sanitária"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Pano de Chão"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Lustra Móveis"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Limpa Vidro"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Sacos de Lixo"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Flanela"
        item.categoria = 6
        inserir(item, bd)

        item.nome = "Sabonete"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Escova de Dente"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Pasta de Dente"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Fio Dental"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Cotonete"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Shampoo"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Condicionador"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Hidratante"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Desodorante"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Protetor Solar"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Lenços de Papel"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Lenços Umidecidos"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Papel Higiênico"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Algodão"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Curativos"
        item.categoria = 7
        inserir(item, bd)

        item.nome = "Água Mineral"
        item.categoria = 8
        inserir(item, bd)

        item.nome = "Suco"
        item.categoria = 8
        inserir(item, bd)

        item.nome = "Refrigerante"
        item.categoria = 8
        inserir(item, bd)

        item.nome = "Chá"
        item.categoria = 8
        inserir(item, bd)

        item.nome = "Cerveja"
        item.categoria = 8
        inserir(item, bd)

        item.nome = "Vinho"
        item.categoria = 8
        inserir(item, bd)

        item.nome = "Ice"
        item.categoria = 8
        inserir(item, bd)
    }
}