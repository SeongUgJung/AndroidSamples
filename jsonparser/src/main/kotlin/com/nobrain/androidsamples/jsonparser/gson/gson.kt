package com.nobrain.androidsamples.jsonparser.gson

import com.vimeo.stag.UseStag

@UseStag
data class Data (
    @JvmField var users: List<User>? = null
)

@UseStag
data class User (
    @JvmField var _id: String? = null,
    @JvmField var index: Long = 0L,
    @JvmField var guid: String? = null,
    @JvmField var isActive: Boolean = false,
    @JvmField var balance: String? = null,
    @JvmField var picture: String? = null,
    @JvmField var age: Int = 0,
    @JvmField var eyeColor: String? = null,
    @JvmField var name: String? = null,
    @JvmField var gender: String? = null,
    @JvmField var company: String? = null,
    @JvmField var email: String? = null,
    @JvmField var phone: String? = null,
    @JvmField var address: String? = null,
    @JvmField var about: String? = null,
    @JvmField var registered: String? = null,
    @JvmField var latitude: Double = 0.toDouble(),
    @JvmField var longitude: Double = 0.toDouble(),
    @JvmField var greeting: String? = null,
    @JvmField var favoriteFruit: String? = null,
    @JvmField var tags: List<String>? = null,
    @JvmField var friends: List<Friend>? = null
)

@UseStag
data class Friend (
    @JvmField var id: Long? = 0L,
    @JvmField var name: String? = null
)