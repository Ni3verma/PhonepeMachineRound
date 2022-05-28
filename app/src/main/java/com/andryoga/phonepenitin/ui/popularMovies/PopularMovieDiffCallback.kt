package com.andryoga.phonepenitin.ui.popularMovies

import androidx.recyclerview.widget.DiffUtil
import com.andryoga.phonepenitin.domain.MovieListItem

class PopularMovieDiffCallback : DiffUtil.ItemCallback<MovieListItem>() {
    override fun areItemsTheSame(oldItem: MovieListItem, newItem: MovieListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieListItem, newItem: MovieListItem): Boolean {
        return oldItem == newItem
    }
}