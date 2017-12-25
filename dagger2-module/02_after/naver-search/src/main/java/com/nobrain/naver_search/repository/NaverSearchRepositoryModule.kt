package com.nobrain.naver_search.repository

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [NaverSearchRepositoryModule.Binder::class])
class NaverSearchRepositoryModule {
    @Provides
    fun api(okHttpClient: OkHttpClient): Api =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://openapi.naver.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
            .create(Api::class.java)

    @Module
    abstract class Binder {
        @Binds
        abstract fun naverSearchRepository(impl: NaverSearchRepositoryImpl): NaverSearchRepository
    }
}
