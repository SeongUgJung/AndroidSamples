package com.nobrain.androidsamples.kotlincoroutines

import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.launch


class ChannelExample(tv: TextView, btn: Button) {
    val producer = produce<Int>(CommonPool) {
        var index = 0
        while (true) {
            send(index * index)
            println("producer : ${index}")
            index++
        }

    }
    init {
        btn.setOnClickListener {
            launch(UI) {
                tv.text = "Channel : ${producer.receive()}"
            }
        }
    }
}
