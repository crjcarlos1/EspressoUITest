package com.cralos.espressouitest.data.source

import com.cralos.espressouitest.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}