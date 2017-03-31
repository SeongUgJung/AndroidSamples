package com.nobrain.dagger2.dagger.search

import com.nobrain.dagger2.presenter.search.SearchPresenter
import com.nobrain.dagger2.presenter.search.SearchPresenterImpl
import com.nobrain.dagger2.ui.search.SearchActivity
import com.nobrain.dagger2.ui.search.adapter.SearchResultAdapter
import com.nobrain.dagger2.ui.search.adapter.SearchResultAdapterModel
import com.nobrain.dagger2.ui.search.adapter.SearchResultAdapterView
import dagger.Module
import dagger.Provides
import dagger.Subcomponent


@Subcomponent(modules = arrayOf(SearchModule::class))
interface SearchComponent {
    fun inject(activity: SearchActivity)
}

@Module
class SearchModule(private val view: SearchPresenter.View, private val adapter: SearchResultAdapter) {

    @Provides
    internal fun searchPresenter(presenter: SearchPresenterImpl): SearchPresenter {
        return presenter
    }

    @Provides
    internal fun view(): SearchPresenter.View {
        return view
    }

    @Provides
    internal fun adapterView(): SearchResultAdapterView {
        return adapter
    }

    @Provides
    internal fun adapterModel(): SearchResultAdapterModel {
        return adapter
    }
}