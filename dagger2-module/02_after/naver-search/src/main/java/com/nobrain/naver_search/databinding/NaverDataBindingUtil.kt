package com.nobrain.naver_search.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.nobrain.common_style.BookRecyclerAdapter
import com.nobrain.naver_search.repository.domain.Book
import com.nobrain.naver_search.repository.domain.toBookItem


@BindingAdapter("naverserch:adapter")
fun setDaumData(view: RecyclerView, datas :List<Book>) {
    view.adapter?.let { adapter ->
        if (adapter is BookRecyclerAdapter) {
            adapter.updateDatas(datas.map { it.toBookItem() })
            adapter.notifyDataSetChanged()
        }
    }

}