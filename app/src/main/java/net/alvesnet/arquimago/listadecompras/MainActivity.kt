package net.alvesnet.arquimago.listadecompras

import android.content.Intent
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

         if (id == R.id.action_edit_mode) {
             isEditing = !isEditing
             val edit = Intent(this,EditActivity::class.java)
             startActivity(edit)

             return true
         }

         return super.onOptionsItemSelected(item)
     }

    override fun onBackPressed() {
        System.exit(0)
        super.onBackPressed()
    }



}
