package net.alvesnet.arquimago.listadecompras

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_page.view.*


class ItemFragment : Fragment() {

    private var categoria: Int = 0
    private var nomeCategoria = "categoria"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            nomeCategoria = savedInstanceState.getString(ARG_PAGE_NAME)
            categoria = savedInstanceState.getInt(ARG_PAGE)
        } else {
            nomeCategoria = arguments?.getString(ARG_PAGE_NAME)!!
            categoria = arguments?.getInt(ARG_PAGE)!!
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_page, container, false)

        val bd = BD(activity!!)
        val lista = bd.buscarCategoria(categoria + 1)
        bd.fechar()

        var rv = view.RV
        rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv.adapter = ListaAdapter(lista, context)

        return view
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(ARG_PAGE, categoria)
        savedInstanceState.putString(ARG_PAGE_NAME, nomeCategoria)
    }

    companion object {
        const val ARG_PAGE_NAME = "ARG_PAGE_NAME"
        const val ARG_PAGE = "ARG_PAGE"

        @JvmStatic
        fun newInstance(pageName: String, page: Int): ItemFragment {
            val args = Bundle()
            args.putString(ARG_PAGE_NAME, pageName)
            args.putInt(ARG_PAGE, page)
            val fragment = ItemFragment()
            fragment.arguments = args
            return fragment
        }
    }


}
