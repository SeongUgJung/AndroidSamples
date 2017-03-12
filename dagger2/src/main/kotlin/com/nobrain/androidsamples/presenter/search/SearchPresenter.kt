package com.nobrain.androidsamples.presenter.search


interface SearchPresenter {

    fun onSearch(query: String)

    interface View {

        fun refreshImages()
    }
}
