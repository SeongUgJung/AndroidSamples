package com.nobrain.androidsamples.dagger2.presenter.search


import android.text.TextUtils
import com.nobrain.androidsamples.dagger2.api.Api
import com.nobrain.androidsamples.dagger2.ui.search.adapter.SearchResultAdapterModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.PublishProcessor
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchPresenterImpl @Inject internal constructor(private val view: SearchPresenter.View, private val adapterModel: SearchResultAdapterModel, private val api: Api) : SearchPresenter {
    private val searchSubject: PublishProcessor<String> = PublishProcessor.create<String>()

    init {
        initsearch()
    }

    private fun initsearch() {
        searchSubject
            .throttleLast(200, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                this.adapterModel.clear()
                this.view.refreshImages()
            }
            .observeOn(Schedulers.io())
            .filter { !TextUtils.isEmpty(it) }
            .toObservable()
            .concatMap { this.api.searchImages(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                this.adapterModel.addItems(it.item)
                this.view.refreshImages()
            }, { it.printStackTrace() })
    }


    override fun onSearch(query: String) {
        searchSubject.onNext(query)
    }
}
