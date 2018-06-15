package net.alvesnet.arquimago.listadecompras

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class AbasAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var PAGE_COUNT = 8
    var tabTitles = arrayOf("Temperos", "Cozinhar", "Café da Manhã", "Diversos", "Feira", "Limpeza", "Higiene", "Bebidas")

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {
        return ItemFragment.newInstance(tabTitles[position], position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}