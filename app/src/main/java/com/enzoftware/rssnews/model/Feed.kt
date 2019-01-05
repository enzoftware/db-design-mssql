package com.enzoftware.rssnews.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Feed (
    @SerializedName("i")
    val feedId: Int,

    @SerializedName("n")
    val name: String,

    @SerializedName("l")
    val url: String
): Serializable