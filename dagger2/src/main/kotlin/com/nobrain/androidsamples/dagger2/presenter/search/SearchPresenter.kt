package com.nobrain.androidsamples.dagger2.presenter.search


interface SearchPresenter {

    fun onSearch(query: String)

    interface View {

        fun refreshImages()
    }
}
