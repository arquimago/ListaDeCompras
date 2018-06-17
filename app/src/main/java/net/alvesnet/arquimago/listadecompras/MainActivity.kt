package net.alvesnet.arquimago.listadecompras

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.viewpager
import kotlinx.android.synthetic.main.activity_main.sliding_tabs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabTitles = arrayOf("Temperos", "Cozinhar", "Café da Manhã", "Diversos", "Feira", "Limpeza", "Higiene", "Bebidas")

        viewpager.adapter = AbasAdapter(supportFragmentManager, tabTitles)

        sliding_tabs.setupWithViewPager(viewpager)
    }
}
