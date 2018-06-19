package net.alvesnet.arquimago.listadecompras

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
         // Handle action bar item clicks here. The action bar will
         // automatically handle clicks on the Home/Up button, so long
         // as you specify a parent activity in AndroidManifest.xml.
         val id = item.itemId

         if (id == R.id.action_edit_mode) {
             isEditing = !isEditing

             return true
         }

         return super.onOptionsItemSelected(item)
     }

}
