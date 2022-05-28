package com.andryoga.phonepenitin.domain.mock

import com.google.gson.annotations.SerializedName

data class MockMovieItem(
    @SerializedName("backdrop_path")
    val imageURL:String,

    @SerializedName("id")
    val id:Long,

    @SerializedName("original_title")
    val title:String,

    @SerializedName("overview")
    val description:String
)
