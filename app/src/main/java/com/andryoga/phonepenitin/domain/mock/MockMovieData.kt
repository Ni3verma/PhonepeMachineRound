package com.andryoga.phonepenitin.domain.mock

import com.google.gson.annotations.SerializedName

data class MockMovieData(
    @SerializedName("results")
    val movieList: List<MockMovieItem>
)
