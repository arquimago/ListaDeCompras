package net.alvesnet.arquimago.listadecompras

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.fragment_item.view.*

class ListaAdapter(private val itens: List<ItemDaLista>) : RecyclerView.Adapter<ListaAdapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(itemHolder: ItemHolder, position: Int) {
        val item = itens[position]
        itemHolder.checkBox.text = item.nome
        itemHolder.checkBox.isChecked = item.comprar

        with(itemHolder.view) {
            tag = item
            this.checkBoxItem.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
                val bd = BD(context)
                item.comprar = b
                bd.atualizar(item)
                bd.fechar()
            }
        }
    }

    override fun getItemCount(): Int = itens.size

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view = itemView
        val checkBox: CheckBox = view.checkBoxItem

        override fun toString(): String {
            return super.toString() + " '" + checkBox.text + "'"
        }

    }
}