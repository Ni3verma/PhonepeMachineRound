package com.andryoga.phonepenitin.domain

import com.andryoga.phonepenitin.common.Constants.IMAGE_BASE_PATH
import com.andryoga.phonepenitin.domain.mock.MockMovieItem

object Mapper {
    fun MockMovieItem.toMovieListItem(): MovieListItem{
        return MovieListItem(
            id, title, description, IMAGE_BASE_PATH+imageURL
        )
    }
}