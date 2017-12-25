package com.nobrain.naver_search.repository

import com.nobrain.naver_search.BuildConfig
import com.nobrain.naver_search.repository.domain.BookResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface NaverSearchRepository {
    fun search(query: String): Single<BookResponse>
}

class NaverSearchRepositoryImpl constructor(retrofit: Retrofit) : NaverSearchRepository {
    private val api: Api by lazy { retrofit.create(Api::class.java) }

    override fun search(query: String): Single<BookResponse> {
        return api.search(query, 100)
    }

}

private interface Api {

    @Headers("X-Naver-Client-Id: ${BuildConfig.NAVER_CLIENT_ID}",
        "X-Naver-Client-Secret: ${BuildConfig.NAVER_CLIENT_SECRET}")
    @GET("v1/search/book.json")
    fun search(@Query("query") query: String,
               @Query("display") count: Int): Single<BookResponse>
}

fun retrofit(okHttpClientFactory: () -> OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClientFactory())
        .baseUrl("https://openapi.naver.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
}

fun okHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC})
        .build()
}