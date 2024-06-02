package kmm.superApp.android.ui.screens.movie.genre


sealed class GenreIntent {
    data object GetGenre : GenreIntent()
}