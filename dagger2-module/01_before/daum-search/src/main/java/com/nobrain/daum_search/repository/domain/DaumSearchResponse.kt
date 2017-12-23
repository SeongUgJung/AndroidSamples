package com.nobrain.daum_search.repository.domain

import com.nobrain.common_style.BookItem


data class DaumResponse(val channel: Channel)

data class Channel(val description: String? = null,
                   val generator: String? = null,
                   val item: List<Book>)

data class Book(val author: String? = null,
                val barcode: String? = null,
                val category: String? = null,
                val cover_l_url: String? = null,
                val cover_s_url: String? = null,
                val description: String? = null,
                val ebook_barcode: String? = null,
                val etc_author: String? = null,
                val isbn: String? = null,
                val isbn13: String? = null,
                val link: String? = null,
                val list_price: String? = null,
                val pub_date: String? = null,
                val pub_nm: String? = null,
                val sale_price: String? = null,
                val sale_yn: String? = null,
                val status_des: String? = null,
                val title: String? = null,
                val translator: String? = null)

fun Book.toBookItem() = BookItem(title, cover_s_url, author)