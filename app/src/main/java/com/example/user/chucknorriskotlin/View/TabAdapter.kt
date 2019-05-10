package com.example.user.chucknorriskotlin.View

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return RandomJoke()
            }
            1 -> {
                return ChangeCharacter()
            }
            2 -> {
            return NeverEnding()

            }
            else -> return null
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }

}