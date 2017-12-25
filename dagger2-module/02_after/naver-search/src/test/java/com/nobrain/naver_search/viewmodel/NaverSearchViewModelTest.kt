package com.nobrain.naver_search.viewmodel

import com.nhaarman.mockito_kotlin.whenever
import com.nobrain.common_repository.SearchQueryRepository
import com.nobrain.naver_search.repository.NaverSearchRepositoryImpl
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import io.reactivex.subjects.BehaviorSubject
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NaverSearchViewModelTest {

    lateinit var viewModel: NaverSearchViewModel

    @get:Rule
    val rxJavaRule = RxSchedulerRule()
    @Mock lateinit var lifecycle: LifecycleProvider<FragmentEvent>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        whenever(lifecycle.bindToLifecycle<FragmentEvent>()).thenReturn(RxLifecycleAndroid.bindFragment(BehaviorSubject.createDefault(FragmentEvent.CREATE)))
        viewModel = NaverSearchViewModel(lifecycle, NaverSearchRepositoryImpl(retrofit { okHttpClient() }))
    }

    @Test
    fun setQuery() {
        SearchQueryRepository.setQuery("Beauty")
        assertThat(viewModel.datas.size).isGreaterThan(0)
    }


}