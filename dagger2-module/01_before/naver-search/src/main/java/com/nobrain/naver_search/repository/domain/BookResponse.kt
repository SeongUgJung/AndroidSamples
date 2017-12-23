package com.nobrain.naver_search.repository.domain

import com.nobrain.common_style.BookItem


data class BookResponse(val items: List<Book>)

data class Book(val title: String? = null,
                val link: String? = null,
                val image: String? = null,
                val author: String? = null,
                val price: String? = null,
                val discount: String? = null,
                val publisher: String? = null,
                val pubdate: String? = null,
                val isbn: String? = null,
                val description: String? = null)

fun Book.toBookItem() = BookItem(title, image, author)