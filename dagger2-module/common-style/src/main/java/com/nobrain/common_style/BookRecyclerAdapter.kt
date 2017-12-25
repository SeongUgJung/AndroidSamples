package com.nobrain.common_style

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
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

    init {
        val widthPixels = itemView.context.resources.displayMetrics.widthPixels
        itemView.layoutParams = itemView.layoutParams.let { lp ->
            lp.width = widthPixels / 3
            lp.height = lp.width
            lp
        }
    }

    fun bind(item: BookItem?) {

        if (item == null) {
            return
        }
        binding.item = item
    }

}

@BindingAdapter("bookitem:imageUrl")
fun imageUrl(view: ImageView, text: String?) {
    text?.takeIf { it.isNotEmpty() }?.let { url ->
        Glide.with(view.context)
            .load(url)
            .centerCrop()
            .into(view)
    }
}
