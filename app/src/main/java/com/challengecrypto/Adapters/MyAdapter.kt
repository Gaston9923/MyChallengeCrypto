package com.challengecrypto.Adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


internal class MyAdapter(var activity:AppCompatActivity, var fragments: ArrayList<Fragment>) : FragmentStateAdapter(activity)  {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }


}