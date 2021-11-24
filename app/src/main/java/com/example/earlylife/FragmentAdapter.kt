package com.example.earlylife

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ActivitiesFragment()
            1 -> StatisticsFragment()
            2 -> HelpFragment()
            else -> Fragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}