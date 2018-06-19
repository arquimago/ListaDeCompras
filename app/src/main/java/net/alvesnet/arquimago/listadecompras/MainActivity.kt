package net.alvesnet.arquimago.listadecompras

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isEditing = false
    private val tabTitles = arrayOf("Temperos", "Cozinhar", "Café da Manhã", "Diversos", "Feira", "Limpeza", "Higiene", "Bebidas")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager.adapter = AbasAdapter(supportFragmentManager, tabTitles, isEditing)

        sliding_tabs.setupWithViewPager(viewpager)

        setSupportActionBar(my_toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
         menuInflater.inflate(R.menu.menu_settings, menu)
         return true
    }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {

         val id = item.itemId

         when (id) {
             R.id.para_comprar -> {
                 val comprar = Intent(this,ComprarActivity::class.java)
                 startActivity(comprar)

                 return true
             }
             R.id.edit_itens -> {
                 val edit = Intent(this,EditActivity::class.java)
                 startActivity(edit)

                 return true
             }

             R.id.clear_itens -> {
                 val bd = BD(this)
                 bd.compreiTudo()

                 val clear = Intent(this,MainActivity::class.java)

                 startActivity(clear)

                 return true
             }

             else -> return super.onOptionsItemSelected(item)
         }
     }


    override fun onBackPressed() {
        System.exit(0)
        super.onBackPressed()
    }
}
