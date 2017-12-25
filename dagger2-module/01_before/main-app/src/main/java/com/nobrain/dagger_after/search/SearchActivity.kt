package com.nobrain.dagger_after.search

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nobrain.common_repository.SearchQueryRepository
import com.nobrain.dagger_after.R
import com.nobrain.dagger_after.databinding.ActivitySearchBinding
import com.nobrain.dagger_after.search.adapter.SearchPagerAdapter

interface SearchView {
    fun onSearchTextChanged(query: String)
}

class SearchActivity : AppCompatActivity(), SearchView {
    val binding: ActivitySearchBinding by lazy { DataBindingUtil.setContentView<ActivitySearchBinding>(this, R.layout.activity_search) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.view = this
        binding.pagerSearch.adapter = SearchPagerAdapter(supportFragmentManager)
    }

    override fun onSearchTextChanged(query: String) {
        SearchQueryRepository.setQuery(query)
    }

    companion object {
        fun startActivit(context: Context) {
            val intent = Intent(context, SearchActivity::class.java)
            context.startActivity(intent)
        }
    }
}