package com.nobrain.androidsamples.jsonparser.logan

import com.bluelinelabs.logansquare.annotation.JsonField
import com.bluelinelabs.logansquare.annotation.JsonObject


@JsonObject
data class LoganData (
    @JvmField @JsonField var users: List<LoganUser>? = null
)

@JsonObject
data class LoganUser (
    @JvmField @JsonField var _id: String? = null,
    @JvmField @JsonField var index: Long = 0L,
    @JvmField @JsonField var guid: String? = null,
    @JvmField @JsonField var isActive: Boolean = false,
    @JvmField @JsonField var balance: String? = null,
    @JvmField @JsonField var picture: String? = null,
    @JvmField @JsonField var age: Int = 0,
    @JvmField @JsonField var eyeColor: String? = null,
    @JvmField @JsonField var name: String? = null,
    @JvmField @JsonField var gender: String? = null,
    @JvmField @JsonField var company: String? = null,
    @JvmField @JsonField var email: String? = null,
    @JvmField @JsonField var phone: String? = null,
    @JvmField @JsonField var address: String? = null,
    @JvmField @JsonField var about: String? = null,
    @JvmField @JsonField var registered: String? = null,
    @JvmField @JsonField var latitude: Double = 0.toDouble(),
    @JvmField @JsonField var longitude: Double = 0.toDouble(),
    @JvmField @JsonField var greeting: String? = null,
    @JvmField @JsonField var favoriteFruit: String? = null,
    @JvmField @JsonField var tags: List<String>? = null,
    @JvmField @JsonField var friends: List<LoganFriend>? = null
)

@JsonObject
data class LoganFriend (
    @JvmField @JsonField var id: Long? = 0L,
    @JvmField @JsonField var name: String? = null
)