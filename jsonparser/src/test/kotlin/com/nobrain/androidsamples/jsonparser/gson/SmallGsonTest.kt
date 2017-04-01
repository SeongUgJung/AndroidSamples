package com.nobrain.androidsamples.jsonparser.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nobrain.androidsamples.jsonparser.Data
import com.vimeo.stag.generated.Stag
import org.junit.Test
import kotlin.system.measureTimeMillis


class SmallGsonTest {
    @Test
    @Throws(Exception::class)
    fun rawTest_recycle() {
        var totalTime = 0L
        var gson = Gson()
        for (index in 1..10000) {
            totalTime += measureTimeMillis {
                gson.fromJson(javaClass.getResourceAsStream("/small.json").reader(),
                    Data::class.java)
            }
        }

        println("${String.format("%06d", totalTime)} : Small Gson Test Recycle Raw")

    }

    @Test
    @Throws(Exception::class)
    fun typeAdapterTest_recycle() {
        var totalTime = 0L
        var gson = GsonBuilder()
            .registerTypeAdapterFactory(Stag.Factory())
            .create()
        for (index in 1..10000) {
            totalTime += measureTimeMillis {
                gson.fromJson(javaClass.getResourceAsStream("/small.json").reader(),
                    Data::class.java)
            }
        }

        println("${String.format("%06d", totalTime)} : Small Gson Test Recycle TypeAdapter")

    }

    @Test
    @Throws(Exception::class)
    fun rawTest_always_new() {
        var totalTime = 0L
        for (index in 1..10000) {
            totalTime += measureTimeMillis {
                Gson().fromJson(javaClass.getResourceAsStream("/small.json").reader(),
                    Data::class.java)
            }
        }

        println("${String.format("%06d", totalTime)} : Small Gson Test Always new Raw")

    }

    @Test
    @Throws(Exception::class)
    fun typeAdapterTest_always_new() {
        var totalTime = 0L
        for (index in 1..10000) {
            totalTime += measureTimeMillis {
                GsonBuilder()
                    .registerTypeAdapterFactory(Stag.Factory())
                    .create()
                    .fromJson(javaClass.getResourceAsStream("/small.json").reader(),
                        Data::class.java)
            }
        }

        println("${String.format("%06d", totalTime)} : Small Gson Test Always new TypeAdapter")

    }
}