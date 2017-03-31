package com.nobrain.dagger2.api


import com.google.gson.annotations.SerializedName
import com.nobrain.dagger2.BuildConfig
import com.nobrain.dagger2.api.model.Images
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class Api @Inject internal constructor(retrofit: Retrofit) {

    private val actualApi: ActualApi

    init {
        actualApi = retrofit.create(ActualApi::class.java)
    }

    fun searchImages(query: String): Observable<Images> {
        return actualApi.searchImages(query)
                .filter { it.image != null }
                .map { it.image }
    }

    internal interface ActualApi {
        @GET("search/image?output=json&apikey=" + BuildConfig.DAUM_API_KEY)
        fun searchImages(@Query("q") query: String): Observable<SearchResult>
    }

    internal class SearchResult {
        @SerializedName("channel")
        var image: Images? = null
    }
}

