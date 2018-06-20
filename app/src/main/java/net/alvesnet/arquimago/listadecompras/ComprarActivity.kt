package net.alvesnet.arquimago.listadecompras

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_comprar.*

class ComprarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar)

        val bd = BD(this)
        val lista = bd.paraComprar()
        bd.fechar()

        var rv = RV

        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rv.adapter = ListaAdapter(lista, false)

        setSupportActionBar(my_toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_edit_settings, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_revert_edit_mode) {
            NavUtils.navigateUpTo(this, parentActivityIntent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        NavUtils.navigateUpTo(this, parentActivityIntent)
        super.onBackPressed()
    }
}
