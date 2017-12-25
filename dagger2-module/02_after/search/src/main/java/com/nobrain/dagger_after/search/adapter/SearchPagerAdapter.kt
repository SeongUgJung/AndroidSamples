package com.nobrain.dagger_after.search.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.nobrain.dagger_after.search.SearchActivity
import com.nobrain.fragment_info.FragmentInfo
import javax.inject.Inject
import javax.inject.Named


class SearchPagerAdapter @Inject constructor(@Named(SearchActivity.TAG) fm: FragmentManager,
                                             fragmentInfos: Set<FragmentInfo>) : FragmentPagerAdapter(fm) {


    private val fragments : List<FragmentInfo> = fragmentInfos.sortedBy { it.order }

    override fun getItem(position: Int) = fragments[position].factory()

    override fun getCount(): Int = fragments.size
    override fun getPageTitle(position: Int): CharSequence? {
        return fragments[position].title
    }
}