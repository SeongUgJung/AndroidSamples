package com.nobrain.daum_search.repository

import com.nobrain.daum_search.BuildConfig
import com.nobrain.daum_search.repository.domain.DaumResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject


const val DAUM_API = "DAUM-API"

interface DaumSearchRepository {

    fun search(query: String): Single<DaumResponse>
}

class DaumSearchRepositoryImpl @Inject constructor(private val api: Api) : DaumSearchRepository {
    override fun search(query: String): Single<DaumResponse> = api.search(query, 20)
}

interface Api {

    @GET("search/book?output=json&apikey=${BuildConfig.DAUM_API_KEY}")
    fun search(@Query("q") query: String, @Query("result") count: Int): Single<DaumResponse>
}
