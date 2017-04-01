package com.nobrain.androidsamples.dagger2

import android.app.Application
import com.facebook.stetho.Stetho
import com.nobrain.androidsamples.dagger2.api.ApiModule
import com.nobrain.androidsamples.dagger2.dagger.search.SearchComponent
import com.nobrain.androidsamples.dagger2.dagger.search.SearchModule
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