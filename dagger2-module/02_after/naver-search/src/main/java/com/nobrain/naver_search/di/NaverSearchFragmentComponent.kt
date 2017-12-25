package com.nobrain.naver_search.di

import android.support.v4.app.Fragment
import com.nobrain.fragment_info.fragmentInfo
import com.nobrain.naver_search.NaverSearchFragment
import com.nobrain.naver_search.repository.NaverSearchRepositoryModule
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import javax.inject.Named


@Subcomponent(modules = [
    NaverSearchFragmentModule::class,
    NaverSearchRepositoryModule::class
])
interface NaverSearchFragmentComponent : AndroidInjector<NaverSearchFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NaverSearchFragment>()
}

@Module(subcomponents = [NaverSearchFragmentComponent::class],
    includes = [NaverSearchFragmentInfo::class])
interface NaverSearchFragmentBinder {
    @Binds
    @IntoMap
    @FragmentKey(NaverSearchFragment::class)
    fun fragment(builder: NaverSearchFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>
}

@Module
class NaverSearchFragmentModule {
    @Provides
    @Named(NaverSearchFragment.TAG)
    fun lifecycleProvider(fragment: NaverSearchFragment): LifecycleProvider<FragmentEvent> = fragment
}

@Module
class NaverSearchFragmentInfo {
    @Provides
    @IntoSet
    fun fragmentInfo() = fragmentInfo(0, "Naver", { NaverSearchFragment.create() })
}