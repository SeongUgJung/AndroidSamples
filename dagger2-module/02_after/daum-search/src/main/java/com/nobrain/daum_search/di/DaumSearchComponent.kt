package com.nobrain.daum_search.di

import android.support.v4.app.Fragment
import com.nobrain.daum_search.DaumSearchFragment
import com.nobrain.daum_search.repository.DaumSearchRepositoryModule
import com.nobrain.fragment_info.fragmentInfo
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
    DaumSearchFragmentModule::class,
    DaumSearchRepositoryModule::class
])
interface DaumSearchComponent : AndroidInjector<DaumSearchFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DaumSearchFragment>()
}

@Module(subcomponents = [DaumSearchComponent::class],
    includes = [DaumSearchFragmentInfo::class])
interface DaumSearchFragmentBinder {
    @Binds
    @IntoMap
    @FragmentKey(DaumSearchFragment::class)
    fun builder(builder: DaumSearchComponent.Builder): AndroidInjector.Factory<out Fragment>
}

@Module
class DaumSearchFragmentModule {
    @Provides
    @Named(DaumSearchFragment.TAG)
    fun lifecycleProvider(fragment: DaumSearchFragment): LifecycleProvider<FragmentEvent> = fragment


}

@Module
class DaumSearchFragmentInfo {
    @Provides
    @IntoSet
    fun fragmentInfo() = fragmentInfo(1, "Daum", { DaumSearchFragment.create() })
}