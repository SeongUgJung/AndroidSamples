package com.nobrain.dagger_after.search.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.nobrain.daum_search.DaumSearchFragment
import com.nobrain.naver_search.NaverSearchFragment


data class FragmentInfo(val factory: (() -> Fragment),
                        val title: (() -> String))

fun fragmentInfo(factory: (() -> Fragment), title: (() -> String)): FragmentInfo {
    return FragmentInfo(factory, title)
}

class SearchPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = arrayOf(
        fragmentInfo({ NaverSearchFragment.create() }, { "Naver" }),
        fragmentInfo({ DaumSearchFragment.create() }, { "Daum" })
    )

    override fun getItem(position: Int) = fragments[position].factory()

    override fun getCount(): Int = fragments.size
    override fun getPageTitle(position: Int): CharSequence? {
        return fragments[position].title()
    }
}