package com.nobrain.daum_search.viewmodel

import com.nhaarman.mockito_kotlin.whenever
import com.nobrain.common_repository.SearchQueryRepository
import com.nobrain.daum_search.repository.DaumSearchRepositoryImpl
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

class DaumSearchViewModelTest {

    @get:Rule
    val rxRule = RxSchedulerRule()
    @Mock lateinit var lifecycleProvider: LifecycleProvider<FragmentEvent>

    lateinit var viewModel: DaumSearchViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        whenever(lifecycleProvider.bindToLifecycle<FragmentEvent>()).thenReturn(RxLifecycleAndroid.bindFragment(BehaviorSubject.createDefault(FragmentEvent.CREATE)))
        viewModel = DaumSearchViewModel(lifecycleProvider, DaumSearchRepositoryImpl(retrofit { okHttpClient() }))
    }

    @Test
    fun setQuery() {

        SearchQueryRepository.setQuery("Beauty")
        assertThat(viewModel.data.size).isGreaterThan(0)

    }
}