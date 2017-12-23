package com.nobrain.dagger_before.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nobrain.dagger_before.R
import com.nobrain.dagger_before.databinding.ActivityHomeBinding
import com.nobrain.dagger_before.search.SearchActivity


class HomeActivity : AppCompatActivity(), HomeView {
    val binding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }

    override fun onNextClick() {
        SearchActivity.startActivit(this)
    }
}

interface HomeView {
    fun onNextClick()
}