package net.alvesnet.arquimago.listadecompras

import android.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.android.synthetic.main.fragment_item.view.*



class ListaAdapter(private val itens: MutableList<ItemDaLista>, private val isEdting: Boolean) : RecyclerView.Adapter<ListaAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)

        return ItemHolder(view)
    }

    override fun onBindViewHolder(itemHolder: ItemHolder, position: Int) {
        val item = itens[position]
        itemHolder.checkBox.text = item.nome
        if (isEdting) {
            itemHolder.deleteButton.visibility = View.VISIBLE
            itemHolder.editButton.visibility = View.VISIBLE
            itemHolder.checkBox.isChecked = false
            itemHolder.checkBox.isEnabled = false
        } else {
            itemHolder.deleteButton.visibility = View.INVISIBLE
            itemHolder.editButton.visibility = View.INVISIBLE
            itemHolder.checkBox.isChecked = item.comprar
            itemHolder.checkBox.isEnabled = true
        }

        with(itemHolder.view) {
            tag = item
            this.checkBoxItem.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
                val bd = BD(context)
                item.comprar = b
                bd.atualizar(item)
                bd.fechar()
            }

            this.editButton.setOnClickListener {
                val alertBuilder = AlertDialog.Builder(context)
                alertBuilder.setTitle("Alterar nome")
                alertBuilder.setMessage("Digite o novo nome do item: ")
                val editText = EditText(context)
                editText.hint = "Novo Nome"
                alertBuilder.setView(editText)

                alertBuilder.setPositiveButton("Alterar") { _, _ ->
                    item.nome = editText.text.toString()
                    val bd = BD(context)
                    bd.atualizar(item)
                    bd.fechar()
                    notifyItemChanged(position)
                }

                alertBuilder.setNegativeButton("Descartar") { _, _ -> }

                alertBuilder.create().show()

            }

            this.deleteButton.setOnClickListener {

                val alertBuilder = AlertDialog.Builder(context)
                alertBuilder.setTitle("Confirmação")
                alertBuilder.setMessage("Deseja realmente apagar " + item.nome + " da lista?")
                alertBuilder.setPositiveButton("SIM") { _, _ ->
                    val bd = BD(context)
                    bd.apagar(item)
                    bd.fechar()
                    itens.removeAt(position)
                    notifyItemRemoved(position)
                }
                alertBuilder.setNegativeButton("NÃO") { _, _ -> }

                alertBuilder.create().show()
            }
        }
    }

    override fun getItemCount(): Int = itens.size

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view = itemView
        val checkBox: CheckBox = view.checkBoxItem
        val editButton: ImageButton = view.editButton
        val deleteButton: ImageButton = view.deleteButton

        override fun toString(): String {
            return super.toString() + " '" + checkBox.text + "'"
        }


    }
}