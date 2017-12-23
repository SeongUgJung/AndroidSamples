package com.nobrain.common_repository

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject


object SearchQueryRepository {

    private val searchQuery = BehaviorSubject.createDefault("")

    fun query() : Observable<String> = searchQuery

    fun setQuery(query:String) = searchQuery.onNext(query)
}