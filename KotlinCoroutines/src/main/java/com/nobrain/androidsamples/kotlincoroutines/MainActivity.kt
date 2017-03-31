package com.nobrain.androidsamples.kotlincoroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.act_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.buildSequence


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        launch(CommonPool) {
            delay(1000)

            val data = doSomething().await()
            runOnUiThread { tv_main.text = data }
        }

        launch(CommonPool) {
            delay(1000)
            runOnUiThread { tv_main2.text = "${tv_main2.text} launch" }
        }

        tv_main.text = "${tv_main.text} ready"
        tv_main2.text = "${tv_main.text} ready"

        buildSequence {
            for (i in 1..10) yield(i * i)
            println("over")
        }

    }

    suspend fun doSomething() = async(CommonPool) {
        "${tv_main.text} - Async Await"
    }


}