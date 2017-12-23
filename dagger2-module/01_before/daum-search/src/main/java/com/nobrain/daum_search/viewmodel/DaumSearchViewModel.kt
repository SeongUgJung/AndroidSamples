package com.nobrain.daum_search.viewmodel

import android.databinding.ObservableArrayList
import android.support.annotation.VisibleForTesting
import com.nobrain.common_repository.SearchQueryRepository
import com.nobrain.daum_search.repository.DaumSearchRepository
import com.nobrain.daum_search.repository.domain.Book
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import io.reactivex.android.schedulers.AndroidSchedulers

class DaumSearchViewModel(lifecycleProvider: LifecycleProvider<FragmentEvent>,
                          @VisibleForTesting val searchRepository: DaumSearchRepository) {

    @VisibleForTesting
    val data = ObservableArrayList<Book>()

    init {
        SearchQueryRepository.query()
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