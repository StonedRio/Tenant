package com.example.tenant.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tenant.fragments.CompletedFragment
import com.example.tenant.fragments.InProgressFragment
import com.example.tenant.fragments.NewJobsFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewJobsFragment()
            1 -> InProgressFragment()
            2 -> CompletedFragment()
            else -> NewJobsFragment()
        }
    }
}