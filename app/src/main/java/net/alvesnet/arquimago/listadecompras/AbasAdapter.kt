package net.alvesnet.arquimago.listadecompras

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class AbasAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var tabTitles = arrayOf("Temperos", "Cozinhar", "Café da Manhã", "Diversos", "Feira", "Limpeza", "Higiene", "Bebidas")

    override fun getCount() = tabTitles.size

    override fun getItem(position: Int) = ItemFragment.newInstance(position)

    override fun getPageTitle(position: Int) = tabTitles[position]
}
