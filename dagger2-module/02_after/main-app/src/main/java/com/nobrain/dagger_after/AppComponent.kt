package com.nobrain.dagger_after

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    SearchBinder::class
])
interface AppComponent {
    fun inject(app: AfterApplication)
}