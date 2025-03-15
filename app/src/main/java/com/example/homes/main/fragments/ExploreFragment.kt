package com.example.homes.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.homes.R
import com.example.homes.explore.adapter.ExploreTabAdapter
import com.google.android.material.tabs.TabLayout

class ExploreFragment : Fragment() {
    private lateinit var tab: TabLayout

    private lateinit var viewPagerTab: ViewPager2
    private lateinit var tabAdapter: ExploreTabAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initAdapter()
        addTabs()

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPagerTab.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        viewPagerTab.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tab.selectTab(tab.getTabAt(position))
            }
        })
    }

    private fun initViews(view: View) {
        tab = view.findViewById(R.id.exploreTabs)
        viewPagerTab = view.findViewById(R.id.tabContent)
    }

    private fun addTabs() {
        tab.addTab(tab.newTab().setText("Popular"))
        tab.addTab(tab.newTab().setText("Attention"))
        tab.addTab(tab.newTab().setText("Local"))
    }

    private fun initAdapter() {
        tabAdapter = ExploreTabAdapter(getChildFragmentManager(), lifecycle)
        viewPagerTab.adapter = tabAdapter
    }
}