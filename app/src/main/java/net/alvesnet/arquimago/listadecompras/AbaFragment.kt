package net.alvesnet.arquimago.listadecompras

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_page.view.*


class AbaFragment : Fragment() {

    private var categoria: Int = 0
    private var isEditing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoria = when (savedInstanceState != null) {
            true -> savedInstanceState!!.getInt(ARG_PAGE)
            false -> arguments?.getInt(ARG_PAGE)!!
        }
        categoria++

        isEditing = when (savedInstanceState != null) {
            true -> savedInstanceState!!.getBoolean(IS_EDITING)
            false -> arguments?.getBoolean(IS_EDITING)!!
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_page, container, false)

        val bd = BD(context!!)
        val lista = bd.buscarCategoria(categoria)
        bd.fechar()

        var rv = view.RV
        rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv.adapter = ListaAdapter(lista, isEditing)

        if (isEditing) {
            view.textAddItem.visibility = View.VISIBLE
            view.buttonAddItem.visibility = View.VISIBLE
            view.buttonAddItem.isClickable = true

            var totalItems = rv.adapter.itemCount

            view.buttonAddItem.setOnClickListener {
                val alertBuilder = AlertDialog.Builder(context)
                alertBuilder.setTitle("Adicionar Item")
                alertBuilder.setMessage("Digite o nome do item: ")
                val editText = EditText(context)
                editText.hint = "Nome do Item"
                alertBuilder.setView(editText)

                alertBuilder.setPositiveButton("Adicionar") { _, _ ->
                    val item = ItemDaLista()
                    item.categoria = categoria
                    item.comprar = false
                    item.nome = editText.text.toString()
                    item.quantidade = 0
                    val bd = BD(it.context)
                    bd.inserir(item)
                    bd.fechar()
                    lista.add(0,item)
                    rv.adapter.notifyItemInserted(0)
                    totalItems++
                }

                alertBuilder.setNegativeButton("Cancelar") { _, _ -> }

                alertBuilder.create().show()
            }

        } else {
            view.textAddItem.visibility = View.GONE
            view.buttonAddItem.visibility = View.GONE
            view.buttonAddItem.isClickable = false
        }

        return view
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(ARG_PAGE, categoria)
    }

    override fun onResume() {
        super.onResume()
        view?.RV!!.adapter.notifyDataSetChanged()
    }

    companion object {
        const val ARG_PAGE = "ARG_PAGE"
        const val IS_EDITING = "IS_EDITING"

        fun newInstance(page: Int, isEditing: Boolean): AbaFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            args.putBoolean(IS_EDITING, isEditing)
            val fragment = AbaFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
