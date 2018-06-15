package net.alvesnet.arquimago.listadecompras

import android.app.Fragment
import android.view.ViewGroup
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View


class ScreenSlidePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup,
                              savedInstanceState: Bundle): View {

        return inflater.inflate(
                R.layout.fragment_item, container, false) as ViewGroup
    }
}