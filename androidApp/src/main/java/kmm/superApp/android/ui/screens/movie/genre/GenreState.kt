package kmm.superApp.android.ui.screens.movie.genre

import kmm.superApp.domain.entity.GenreItemModel


data class GenreState (
    val isLoading: Boolean = false,
    val genre : List<GenreItemModel>  = emptyList(),
    val error: String = ""
)