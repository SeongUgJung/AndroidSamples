package com.nobrain.daum_search

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nobrain.common_style.BookRecyclerAdapter
import com.nobrain.daum_search.databinding.FragmentDaumBinding
import com.nobrain.daum_search.repository.DaumSearchRepositoryImpl
import com.nobrain.daum_search.repository.okHttpClient
import com.nobrain.daum_search.repository.retrofit
import com.nobrain.daum_search.viewmodel.DaumSearchViewModel
import com.trello.rxlifecycle2.components.support.RxFragment


class DaumSearchFragment : RxFragment() {

    lateinit var binding: FragmentDaumBinding
    val viewModel: DaumSearchViewModel by lazy { DaumSearchViewModel(this, DaumSearchRepositoryImpl(retrofit { okHttpClient() })) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDaumBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel
        binding.rvSearch.adapter = BookRecyclerAdapter()
        binding.rvSearch.layoutManager = GridLayoutManager(activity, 3)
    }

    companion object {
        fun create() = DaumSearchFragment()
    }
}