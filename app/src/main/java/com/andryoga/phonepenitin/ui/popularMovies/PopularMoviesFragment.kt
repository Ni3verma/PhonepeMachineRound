package com.andryoga.phonepenitin.ui.popularMovies

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.andryoga.phonepenitin.R
import com.andryoga.phonepenitin.databinding.PopularMoviesFragmentBinding
import com.andryoga.phonepenitin.domain.Mapper.toMovieListItem
import com.andryoga.phonepenitin.domain.MovieListItem
import com.andryoga.phonepenitin.domain.mock.MockMovieData
import com.google.gson.Gson
import java.io.IOException

class PopularMoviesFragment: Fragment() {
    private val viewModel:PopularMoviesViewModel by viewModels()

    private lateinit var binding: PopularMoviesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.popular_movies_fragment, container, false)
        binding.lifecycleOwner = this

        val adapter =PopularMoviesAdapter(MovieClickListener { movie ->
            Log.i("Nitin","${movie.id} clicked")
            findNavController().navigate(
                PopularMoviesFragmentDirections.actionPopularMoviesFragmentToMovieDetailFragment(
                    movie.id
                )
            )
        })

        binding.recyclerView.adapter = adapter

        adapter.submitList(getMockJsonDataFromAsset(requireContext()))

        return binding.root;
    }

    /*
    * this reads data from local json file and return data for recycler view
    * ideally we will be making REST API call which will be async and the route would be
    * viewmodel -> repo -> API
    * Here just to show some data on UI: I am doing IO operation on main thread
    * */
    private fun getMockJsonDataFromAsset(context: Context): MutableList<MovieListItem>? {
        val jsonString: String
        try {
            jsonString = context.assets
                .open("mockMovieData.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null;
        }

        val movieData = Gson().fromJson(jsonString, MockMovieData::class.java).movieList

        val movieListItem = mutableListOf<MovieListItem>()
        for(movie in movieData){
            movieListItem.add(movie.toMovieListItem())
        }

        return movieListItem
    }
}