package com.andryoga.phonepenitin.ui.popularMovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andryoga.phonepenitin.databinding.MovieListItemBinding
import com.andryoga.phonepenitin.domain.MovieListItem

class PopularMoviesAdapter(private val clickListener: MovieClickListener):
    ListAdapter<MovieListItem, PopularMoviesAdapter.PopularMovieViewHolder>(
        PopularMovieDiffCallback()
    ) {

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        return PopularMovieViewHolder.from(parent)
    }

    class PopularMovieViewHolder private constructor(val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieListItem, clickListener: MovieClickListener) {
            binding.data = item
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

        companion object {

            fun from(parent: ViewGroup): PopularMovieViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieListItemBinding.inflate(layoutInflater, parent, false)
                return PopularMovieViewHolder(binding)
            }
        }
    }
}

class MovieClickListener(
    val clickListener: (movie: MovieListItem) -> Unit
) {
    fun onClick(movie: MovieListItem) = clickListener(movie)
}