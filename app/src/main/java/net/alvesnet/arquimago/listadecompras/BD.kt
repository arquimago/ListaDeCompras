package net.alvesnet.arquimago.listadecompras

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class BD (context: Context){

    val auxBd = BDCore(context)
    var bd = auxBd.getWritableDatabase()

    fun inserir(item: ItemDaLista, bd: SQLiteDatabase){
        val valores = ContentValues()
        valores.put("nome", item.nome)
        valores.put("categoria", item.categoria)
        valores.put("comprar", if(item.comprar) 0 else 1)

        val id = bd.insert("itens",null,valores)
        item.id = id
    }

    fun atualizar(item: ItemDaLista) {
        val valores = ContentValues()
        valores.put("nome", item.nome)
        valores.put("categoria", item.categoria)
        valores.put("comprar", if (item.comprar) 0 else 1)
        Log.e("Valores: ", valores.toString())
        val resultado = bd.update("itens", valores, "_id = ?", arrayOf("" + item.id))
        Log.e("Resultado SQL: ", resultado.toString())
    }


    fun apagar(item: ItemDaLista) {
        bd.delete("nome", "_id = " + item.id, null)
    }

    fun buscar(): List<ItemDaLista> {
        val lista = ArrayList<ItemDaLista>()
        val colunas = arrayOf("_id", "nome", "categoria", "comprar")

        val cursor = bd.query("itens", colunas, null, null, null, null, "categoria ASC")

        if (cursor.count > 0) {
            cursor.moveToFirst()

            do {
                val i = ItemDaLista()
                i.id = cursor.getInt(0).toLong()
                i.nome = cursor.getString(1)
                i.categoria = cursor.getInt(2)
                i.comprar = cursor.getInt(3)==1
                lista.add(i)

            } while (cursor.moveToNext())
        }

        return lista
    }

    fun buscarCategoria(categoria: Int): List<ItemDaLista> {
        val lista = ArrayList<ItemDaLista>()
        val colunas = arrayOf("_id", "nome", "categoria", "comprar")

        val cursor = bd.query("itens", colunas, "categoria =$categoria", null, null, null, "nome ASC")

        if (cursor.count > 0) {
            cursor.moveToFirst()

            do {
                val i = ItemDaLista()
                i.id = cursor.getInt(0).toLong()
                i.nome = cursor.getString(1)
                i.categoria = cursor.getInt(2)
                i.comprar = cursor.getInt(3)!=1
                lista.add(i)

            } while (cursor.moveToNext())
        }

        return lista
    }

    fun fechar() {
        bd.close()
    }

}