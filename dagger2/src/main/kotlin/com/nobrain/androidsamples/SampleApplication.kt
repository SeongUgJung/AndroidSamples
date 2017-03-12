package com.nobrain.androidsamples

import android.app.Application
import com.facebook.stetho.Stetho
import com.nobrain.androidsamples.api.ApiModule
import com.nobrain.androidsamples.dagger.search.SearchComponent
import com.nobrain.androidsamples.dagger.search.SearchModule
import dagger.Component


class SampleApplication : Application() {
    lateinit var appComponent: SampleApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        appComponent = DaggerSampleApplicationComponent.create()

    }

    fun appComponent() = appComponent

}

@Component(modules = arrayOf(ApiModule::class))
interface SampleApplicationComponent {
    fun inject(application: SampleApplication)
    fun searchComponent(searchModule: SearchModule): SearchComponent
}