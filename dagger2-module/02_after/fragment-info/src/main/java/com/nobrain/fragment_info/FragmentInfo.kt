package com.nobrain.fragment_info

import android.support.v4.app.Fragment

data class FragmentInfo(
    val order: Int,
    val title: String,
    val factory: () -> Fragment
)

fun fragmentInfo(order: Int, title: String, factory: (() -> Fragment)): FragmentInfo {
    return FragmentInfo(order, title, factory)
}
