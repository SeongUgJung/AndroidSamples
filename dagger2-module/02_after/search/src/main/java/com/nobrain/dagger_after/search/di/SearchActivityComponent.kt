package com.nobrain.dagger_after.search.di

import android.app.Activity
import android.support.v4.app.FragmentManager
import com.nobrain.dagger_after.search.SearchActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Named


@Subcomponent(modules = [SearchActivityModule::class])
interface SearchActivityComponent : AndroidInjector<SearchActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SearchActivity>()

}

@Module(subcomponents = [SearchActivityComponent::class])
abstract class SearchActivityBinder {
    @Binds
    @IntoMap
    @ActivityKey(SearchActivity::class)
    abstract fun searchActivity(builder: SearchActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}

@Module
class SearchActivityModule {
    @Provides @Named(SearchActivity.TAG)
    fun fragmentManager(activity: SearchActivity) :FragmentManager = activity.supportFragmentManager

}