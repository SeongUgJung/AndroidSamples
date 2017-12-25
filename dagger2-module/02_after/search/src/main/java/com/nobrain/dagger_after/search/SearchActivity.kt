package com.nobrain.dagger_after.search

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.nobrain.common_repository.SearchQueryRepository
import com.nobrain.dagger_after.search.adapter.SearchPagerAdapter
import com.nobrain.search.R
import com.nobrain.search.databinding.ActivitySearchBinding
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

interface SearchView {
    fun onSearchTextChanged(query: String)
}

class SearchActivity : AppCompatActivity(), SearchView, HasSupportFragmentInjector {

    @Inject lateinit var searchQueryRepository: SearchQueryRepository
    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var searchPageAdapter: SearchPagerAdapter

    val binding: ActivitySearchBinding by lazy { DataBindingUtil.setContentView<ActivitySearchBinding>(this, R.layout.activity_search) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding.view = this
        binding.pagerSearch.adapter = searchPageAdapter
    }

    override fun onSearchTextChanged(query: String) {
        searchQueryRepository.setQuery(query)
    }

    override fun supportFragmentInjector() = fragmentInjector

    companion object {
        const val TAG = "SearchActivity"
        fun startActivit(context: Context) {
            val intent = Intent(context, SearchActivity::class.java)
            context.startActivity(intent)
        }
    }
}