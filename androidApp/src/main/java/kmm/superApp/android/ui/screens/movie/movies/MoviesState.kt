package kmm.superApp.android.ui.screens.movie.movies

import kmm.superApp.domain.entity.MovieItem


data class MoviesState (
    var loading: Boolean = false,
    var movies: List<MovieItem> = listOf(),
    var errorMessage: String = "",
    var loadFinished: Boolean = false
)