package com.nobrain.naver_search.viewmodel

import android.databinding.ObservableArrayList
import android.support.annotation.VisibleForTesting
import com.nobrain.common_repository.SearchQueryRepository
import com.nobrain.naver_search.repository.NaverSearchRepository
import com.nobrain.naver_search.repository.domain.Book
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import io.reactivex.android.schedulers.AndroidSchedulers


class NaverSearchViewModel constructor(lifecycleProvider: LifecycleProvider<FragmentEvent>,
                                       @VisibleForTesting val searchRepository: NaverSearchRepository) {
    @VisibleForTesting
    val datas = ObservableArrayList<Book>()

    init {
        SearchQueryRepository.query().filter { it.isNotEmpty() }.switchMapSingle { searchRepository.search(it) }
            .compose(lifecycleProvider.bindToLifecycle())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                datas.clear()
                datas.addAll(it.items)
            }, { println(it) })
    }
}