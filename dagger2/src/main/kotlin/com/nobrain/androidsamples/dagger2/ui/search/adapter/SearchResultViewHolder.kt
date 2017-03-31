package com.nobrain.dagger2.ui.search.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.nobrain.dagger2.api.model.Image
import kotlinx.android.synthetic.main.item_search.view.*


class SearchResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Image?) {
        if (item == null) {
            return
        }

        Glide.with(itemView.iv_item_search.context)
                .load(item.thumbnail)
                .centerCrop()
                .into(itemView.iv_item_search)

        itemView.tv_item_search.text = item.title
    }
}
