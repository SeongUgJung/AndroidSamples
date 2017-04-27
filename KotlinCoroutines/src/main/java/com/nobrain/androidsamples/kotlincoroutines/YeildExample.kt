package com.nobrain.androidsamples.kotlincoroutines

import android.widget.Button
import android.widget.TextView
import kotlin.coroutines.experimental.buildSequence


class YeildExample(tv: TextView, btn: Button) {
    val sequence: Sequence<Int> = buildSequence {
        var index = 0
        while (true) {
            yield(index * index)
            println("sequence : ${index}")
            index++
        }
    }

    init {
        btn.setOnClickListener {
            tv.text = "Yield : ${sequence.take(10).joinToString()}"
        }
    }


}