package net.alvesnet.arquimago.listadecompras

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_page.view.*

class AbaFragment : Fragment() {

    private var categoria: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoria = when (savedInstanceState != null) {
            true -> savedInstanceState!!.getInt(ARG_PAGE)
            false -> arguments?.getInt(ARG_PAGE)!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_page, container, false)

        val bd = BD(activity!!)
        val lista = bd.buscarCategoria(categoria + 1)
        bd.fechar()

        var rv = view.RV
        rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv.adapter = ListaAdapter(lista)

        return view
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(ARG_PAGE, categoria)
    }

    companion object {
        const val ARG_PAGE = "ARG_PAGE"

        fun newInstance(page: Int): AbaFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = AbaFragment()
            fragment.arguments = args
            return fragment
        }
    }


}
