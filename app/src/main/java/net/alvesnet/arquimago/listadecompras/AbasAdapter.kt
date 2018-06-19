package net.alvesnet.arquimago.listadecompras

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class AbasAdapter(fm: FragmentManager, private val tabTitles: Array<String>, private val isEditing: Boolean) : FragmentPagerAdapter(fm) {

    override fun getCount() = tabTitles.size

    override fun getItem(position: Int) = AbaFragment.newInstance(position, isEditing)

    override fun getPageTitle(position: Int) = tabTitles[position]

}