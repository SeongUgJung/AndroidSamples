package com.nobrain.dagger_after

import com.nobrain.common_repository.SearchQueryModule
import com.nobrain.dagger_after.search.di.SearchActivityBinder
import com.nobrain.daum_search.di.DaumSearchFragmentBinder
import com.nobrain.naver_search.di.NaverSearchFragmentBinder
import dagger.Module


@Module(includes = [
    SearchQueryModule::class,
    SearchActivityBinder::class,
    DaumSearchFragmentBinder::class,
    NaverSearchFragmentBinder::class
])
interface SearchBinder