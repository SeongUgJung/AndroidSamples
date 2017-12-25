package com.nobrain.naver_search.viewmodel

import android.databinding.ObservableArrayList
import android.support.annotation.VisibleForTesting
import com.nobrain.common_repository.SearchQueryRepository
import com.nobrain.naver_search.NaverSearchFragment
import com.nobrain.naver_search.repository.NaverSearchRepository
import com.nobrain.naver_search.repository.domain.Book
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Named


class NaverSearchViewModel @Inject constructor(@Named(NaverSearchFragment.TAG) lifecycleProvider: LifecycleProvider<FragmentEvent>,
                                               @VisibleForTesting val searchRepository: NaverSearchRepository,
                                               searchQueryRepository: SearchQueryRepository) {
    @VisibleForTesting
    val datas = ObservableArrayList<Book>()

    init {
        searchQueryRepository.query()
            .filter { it.isNotEmpty() }
            .switchMapSingle { searchRepository.search(it) }
            .compose(lifecycleProvider.bindToLifecycle())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                datas.clear()
                datas.addAll(it.items)
            }, { println(it) })
    }
}