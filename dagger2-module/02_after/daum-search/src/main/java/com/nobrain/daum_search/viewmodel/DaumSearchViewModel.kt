package com.nobrain.daum_search.viewmodel

import android.databinding.ObservableArrayList
import android.support.annotation.VisibleForTesting
import com.nobrain.common_repository.SearchQueryRepository
import com.nobrain.daum_search.DaumSearchFragment
import com.nobrain.daum_search.repository.DaumSearchRepository
import com.nobrain.daum_search.repository.domain.Book
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Named

class DaumSearchViewModel @Inject constructor(@Named(DaumSearchFragment.TAG) lifecycleProvider: LifecycleProvider<FragmentEvent>,
                                              @VisibleForTesting val searchRepository: DaumSearchRepository,
                                              searchQueryRepository: SearchQueryRepository) {

    @VisibleForTesting
    val data = ObservableArrayList<Book>()

    init {
        searchQueryRepository.query()
            .filter { it.isNotEmpty() }
            .switchMapSingle { searchRepository.search(it) }
            .compose(lifecycleProvider.bindToLifecycle())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.clear()
                data.addAll(it.channel.item)
            }, { println(it) })

    }

}