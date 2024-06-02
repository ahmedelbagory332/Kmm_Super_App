package kmm.superApp.android.ui.screens.movie.movies


sealed class MoviesIntent {
    data class GetMovies(val genresId: String, val forceReload: Boolean = false) : MoviesIntent()
}