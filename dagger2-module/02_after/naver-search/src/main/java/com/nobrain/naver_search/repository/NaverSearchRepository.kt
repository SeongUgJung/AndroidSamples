package com.nobrain.naver_search.repository

import com.nobrain.naver_search.BuildConfig
import com.nobrain.naver_search.repository.domain.BookResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Inject


interface NaverSearchRepository {
    fun search(query: String): Single<BookResponse>
}

class NaverSearchRepositoryImpl @Inject constructor(private val api: Api) : NaverSearchRepository {

    override fun search(query: String): Single<BookResponse> {
        return api.search(query, 100)
    }

}

interface Api {

    @Headers("X-Naver-Client-Id: ${BuildConfig.NAVER_CLIENT_ID}",
        "X-Naver-Client-Secret: ${BuildConfig.NAVER_CLIENT_SECRET}")
    @GET("v1/search/book.json")
    fun search(@Query("query") query: String,
               @Query("display") count: Int): Single<BookResponse>
}