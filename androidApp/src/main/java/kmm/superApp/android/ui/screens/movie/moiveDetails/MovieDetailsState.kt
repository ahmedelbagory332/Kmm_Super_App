package kmm.superApp.android.ui.screens.movie.moiveDetails

import kmm.superApp.domain.entity.MovieDetailsModel


data class MovieDetailsState(
    val isLoading: Boolean = false,
    val movie: MovieDetailsModel = MovieDetailsModel(),
    val error: String = ""
)
