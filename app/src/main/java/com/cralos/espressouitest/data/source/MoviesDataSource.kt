package com.cralos.espressouitest.data.source

import com.cralos.espressouitest.data.Movie

interface MoviesDataSource {
    fun getMovies(): List<Movie>
    fun getMovie(movieId: Int): Movie?
}