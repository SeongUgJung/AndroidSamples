package com.nobrain.androidsamples.base.adapter


interface AdapterModel<T> {
    fun addItems(items: List<T>)

    fun addItem(item: T)

    fun getItem(position: Int): T?

    fun clear()

    fun size(): Int
}

interface AdapterView {
    fun refresh()
}
