package com.nobrain.dagger_after

import android.app.Activity
import android.support.multidex.MultiDexApplication
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class AfterApplication : MultiDexApplication(), HasActivityInjector, HasSupportFragmentInjector {
    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment>  = fragmentInjector

}

