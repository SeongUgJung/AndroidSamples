package com.nobrain.dagger2.presenter.search


interface SearchPresenter {

    fun onSearch(query: String)

    interface View {

        fun refreshImages()
    }
}
