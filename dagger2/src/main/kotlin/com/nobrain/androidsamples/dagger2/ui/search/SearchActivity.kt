package com.nobrain.androidsamples.dagger2.ui.search


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.nobrain.androidsamples.dagger2.R
import com.nobrain.androidsamples.dagger2.SampleApplication
import com.nobrain.androidsamples.dagger2.base.view.SimpleTextWatcher
import com.nobrain.androidsamples.dagger2.dagger.search.SearchModule
import com.nobrain.androidsamples.dagger2.presenter.search.SearchPresenter
import com.nobrain.androidsamples.dagger2.ui.search.adapter.SearchResultAdapter
import com.nobrain.androidsamples.dagger2.ui.search.adapter.SearchResultAdapterView
import kotlinx.android.synthetic.main.act_main.*
import javax.inject.Inject


class SearchActivity : AppCompatActivity(), SearchPresenter.View {

    @Inject lateinit internal var searchPresenter: SearchPresenter
    @Inject lateinit var adapterView: SearchResultAdapterView
    val adapter by lazy { SearchResultAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        (applicationContext as SampleApplication)
            .appComponent
            .searchComponent(SearchModule(this, adapter))
            .inject(this)

        rv_main_result.layoutManager = GridLayoutManager(rv_main_result.context, 3)
        rv_main_result.adapter = adapter

        et_main_search.addTextChangedListener(object : SimpleTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchPresenter.onSearch(s.toString())
            }
        })
    }

    override fun refreshImages() {
        adapterView.refresh()
    }
}
