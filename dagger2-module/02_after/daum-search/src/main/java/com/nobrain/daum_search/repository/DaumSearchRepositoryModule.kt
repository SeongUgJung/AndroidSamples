package com.nobrain.daum_search.repository

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [DaumSearchRepositoryModule.Binder::class])
class DaumSearchRepositoryModule {


    @Provides
    fun api(okHttpClient: OkHttpClient): Api {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://apis.daum.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
            .create(Api::class.java)

    }

    @Module
    interface Binder {
        @Binds
        fun daumSearchRepository(impl: DaumSearchRepositoryImpl): DaumSearchRepository
    }
}