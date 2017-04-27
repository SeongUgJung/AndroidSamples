package com.nobrain.androidsamples.kotlincoroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.act_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        launch(UI) {
            val data = doSomething().await()
            tv_main.text = data
        }

        launch(UI) {
            delay(1000)
            tv_main2.text = "${tv_main2.text} launch"
        }

        tv_main.text = "${tv_main.text} ready"
        tv_main2.text = "${tv_main2.text} ready"

        YeildExample(tv_main3, btn_main3)
        ChannelExample(tv_main4, btn_main4)
    }

    suspend fun doSomething() = async(CommonPool) {
        delay(1000)
        "${tv_main.text} - Async Await"
    }


}