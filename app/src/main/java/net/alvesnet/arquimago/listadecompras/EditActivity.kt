package net.alvesnet.arquimago.listadecompras

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_edit.*


class EditActivity : AppCompatActivity() {

    var isEditing = true

    private val tabTitles = arrayOf("Temperos", "Cozinhar", "Café da Manhã", "Diversos", "Feira", "Limpeza", "Higiene", "Bebidas")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        viewpager.adapter = AbasAdapter(supportFragmentManager, tabTitles, isEditing)

        sliding_tabs.setupWithViewPager(viewpager)

        setSupportActionBar(my_toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_edit_settings, menu)

        return true
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_revert_edit_mode) {
            NavUtils.navigateUpTo(this, parentActivityIntent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }*/

    override fun onBackPressed() {
        NavUtils.navigateUpTo(this, parentActivityIntent)
        super.onBackPressed()
    }

}