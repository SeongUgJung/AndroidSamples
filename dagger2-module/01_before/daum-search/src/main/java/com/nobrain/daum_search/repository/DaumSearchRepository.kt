package com.nobrain.daum_search.repository

import com.nobrain.daum_search.BuildConfig
import com.nobrain.daum_search.repository.domain.DaumResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface DaumSearchRepository {

    fun search(query: String): Single<DaumResponse>
}

class DaumSearchRepositoryImpl(retrofit: Retrofit) : DaumSearchRepository {

    private val api : Api by lazy { retrofit.create(Api::class.java) }

    override fun search(query: String): Single<DaumResponse> = api.search(query, 20)
}

interface Api {

    @GET("search/book?output=json&apikey=${BuildConfig.DAUM_API_KEY}")
    fun search(@Query("q") query:String, @Query("result") count:Int) : Single<DaumResponse>
}

fun retrofit(okHttpClientFactory: () -> OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClientFactory())
        .baseUrl("https://apis.daum.net/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
}

fun okHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC})
        .build()
}