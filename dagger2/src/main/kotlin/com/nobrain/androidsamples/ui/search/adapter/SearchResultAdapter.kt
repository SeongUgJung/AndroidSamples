package com.nobrain.androidsamples.ui.search.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nobrain.androidsamples.R
import com.nobrain.androidsamples.api.model.Image
import com.nobrain.androidsamples.base.adapter.AdapterModel
import com.nobrain.androidsamples.base.adapter.AdapterView
import java.util.*

interface SearchResultAdapterModel : AdapterModel<Image>
interface SearchResultAdapterView : AdapterView


class SearchResultAdapter(private val items: MutableList<Image> = ArrayList<Image>()) : RecyclerView.Adapter<SearchResultViewHolder>(), SearchResultAdapterView, SearchResultAdapterModel {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        return SearchResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun refresh() {
        notifyDataSetChanged()
    }

    override fun addItems(items: List<Image>) {
        this.items.addAll(items)
    }

    override fun addItem(item: Image) {
        this.items.add(item)
    }

    override fun getItem(position: Int): Image? {
        if (position in 0..size()) {
            return items[position]
        } else {
            return null
        }
    }

    override fun clear() {
        items.clear()
    }

    override fun size(): Int {
        return itemCount
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
