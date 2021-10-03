package com.simplemobiletools.calendar.pro.views.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.simplemobiletools.calendar.pro.views.fragments.*


private const val NUM_TABS = 7

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return SundayFragment()
            1 -> return MondayFragment()
            2 -> return TuesdayFragment()
            3 -> return WednesdayFragment()
            4 -> return ThursdayFragment()
            5 -> return FridayFragment()
            6 -> return SaturdayFragment()

        }
        return MondayFragment()
    }
}
