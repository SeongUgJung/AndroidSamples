package com.nobrain.naver_search

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nobrain.common_style.BookRecyclerAdapter
import com.nobrain.naver_search.databinding.FragmentNaverBinding
import com.nobrain.naver_search.repository.NaverSearchRepositoryImpl
import com.nobrain.naver_search.repository.okHttpClient
import com.nobrain.naver_search.repository.retrofit
import com.nobrain.naver_search.viewmodel.NaverSearchViewModel
import com.trello.rxlifecycle2.components.support.RxFragment


class NaverSearchFragment : RxFragment() {
    lateinit var binding: FragmentNaverBinding
    val viewModel: NaverSearchViewModel by lazy { NaverSearchViewModel(this, NaverSearchRepositoryImpl(retrofit { okHttpClient() })) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNaverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel
        binding.rvSearch.adapter = BookRecyclerAdapter()
        binding.rvSearch.layoutManager = GridLayoutManager(activity, 3)
    }

    companion object {
        fun create() = NaverSearchFragment()
    }

}