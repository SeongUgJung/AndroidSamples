package com.nobrain.common_style

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nobrain.common_style.databinding.ItemBookBinding


class BookRecyclerAdapter : RecyclerView.Adapter<BookViewHolder>() {

    private val datas = mutableListOf<BookItem>()
    private var onItemClickListener: ((Int, BookItem) -> Unit)? = null

    fun updateDatas(datas: List<BookItem>) {
        this.datas.clear()
        this.datas.addAll(datas)
    }

    fun setOnItemClickListener(clickListener: ((Int, BookItem) -> Unit)) {
        this.onItemClickListener = clickListener
    }

    fun getItem(position: Int) = datas[position]

    override fun onBindViewHolder(holder: BookViewHolder?, position: Int) {
        holder?.bind(getItem(position))
        holder?.itemView?.setOnClickListener {
            onItemClickListener?.invoke(position, getItem(position))
        }
    }

    override fun getItemCount(): Int = datas.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return BookViewHolder(binding)
    }
}

class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: BookItem?) {

        if (item == null) {
            return
        }

        binding

    }

}