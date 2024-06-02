package kmm.superApp.android.ui.screens.movie.moiveDetails


sealed class MovieIntent {
    data class GetMovies(val movieId:String) : MovieIntent()
}