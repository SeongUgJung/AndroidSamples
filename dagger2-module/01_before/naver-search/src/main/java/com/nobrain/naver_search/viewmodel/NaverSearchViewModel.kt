package com.nobrain.naver_search.viewmodel

import android.databinding.ObservableArrayList
import android.support.annotation.VisibleForTesting
import com.nobrain.naver_search.repository.NaverSearchRepository
import com.nobrain.naver_search.repository.domain.Book
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject


interface NaverSearchViewModel {
    fun setQuery(text: String)
}

class NaverSearchViewModelImpl constructor(
    lifecycleProvider: LifecycleProvider<FragmentEvent>,
    @VisibleForTesting val searchRepository: NaverSearchRepository) : NaverSearchViewModel {
    @VisibleForTesting val datas = ObservableArrayList<Book>()

    @VisibleForTesting val loader = BehaviorSubject.create<String>()

    init {
        loader.switchMapSingle { searchRepository.search(it) }
            .compose(lifecycleProvider.bindToLifecycle())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                datas.clear()
                datas.addAll(it.items)
            }, { println(it) })
    }

    override fun setQuery(text: String) {
        loader.onNext(text)
    }
}