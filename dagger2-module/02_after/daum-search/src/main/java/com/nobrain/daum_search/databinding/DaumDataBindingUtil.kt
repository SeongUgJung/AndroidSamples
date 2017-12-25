package com.nobrain.daum_search.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.nobrain.common_style.BookRecyclerAdapter
import com.nobrain.daum_search.repository.domain.Book
import com.nobrain.daum_search.repository.domain.toBookItem


@BindingAdapter("daumsearch:adapter")
fun setDaumData(view: RecyclerView, datas :List<Book>) {
    view.adapter?.let { adapter ->
        if (adapter is BookRecyclerAdapter) {
            adapter.updateDatas(datas.map { it.toBookItem() })
            adapter.notifyDataSetChanged()
        }
    }

}