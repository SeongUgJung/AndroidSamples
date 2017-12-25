package com.nobrain.common_repository

import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Singleton


class SearchQueryRepository {

    private val searchQuery = BehaviorSubject.createDefault("")

    fun query(): Observable<String> = searchQuery

    fun setQuery(query: String) = searchQuery.onNext(query)

    companion object {
        // for before
        private val repository by lazy { SearchQueryRepository() }

        fun query() = repository.query()
        fun setQuery(query: String) = repository.setQuery(query)

    }
}

@Module
class SearchQueryModule {

    @Singleton
    @Provides
    fun searchQuery() = SearchQueryRepository()
}