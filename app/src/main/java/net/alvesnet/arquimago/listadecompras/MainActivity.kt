package net.alvesnet.arquimago.listadecompras

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.viewpager
import kotlinx.android.synthetic.main.activity_main.sliding_tabs


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager.adapter = AbasAdapter(supportFragmentManager)

        sliding_tabs.setupWithViewPager(viewpager)

    }
}
