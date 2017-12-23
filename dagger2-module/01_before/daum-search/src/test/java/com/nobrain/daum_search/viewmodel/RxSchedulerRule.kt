package com.nobrain.daum_search.viewmodel

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement


class RxSchedulerRule : TestRule {
    override fun apply(p0: Statement?, p1: Description?): Statement {
        return object: Statement() {
            override fun evaluate() {
                RxAndroidPlugins.onMainThreadScheduler(Schedulers.trampoline())
                RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

                RxJavaPlugins.onIoScheduler(Schedulers.trampoline())
                RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
                RxJavaPlugins.setInitIoSchedulerHandler { Schedulers.trampoline() }

                RxJavaPlugins.onComputationScheduler(Schedulers.trampoline())
                RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
                RxJavaPlugins.setInitComputationSchedulerHandler { Schedulers.trampoline() }

                p0?.evaluate()

                RxAndroidPlugins.reset()
                RxJavaPlugins.reset()
            }
        }
    }
}