package com.example.homes.explore.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homes.explore.tabfragments.AttentionFragment
import com.example.homes.explore.tabfragments.LocalFragment
import com.example.homes.explore.tabfragments.PopularFragment
import com.example.homes.main.fragments.ExploreFragment

class ExploreTabAdapter(val fragment: FragmentManager, private val lifecycle: Lifecycle) :
    FragmentStateAdapter(fragment, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PopularFragment()
            1 -> AttentionFragment()
            2 -> LocalFragment()
            else -> {
                ExploreFragment()
            }
        }
    }


}