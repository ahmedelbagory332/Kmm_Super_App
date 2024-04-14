package kmm.superApp.android.ui.screens.movie.movies


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kmm.superApp.domain.use_case.MoviesUseCase
import kotlinx.coroutines.launch


class MoviesViewModel constructor(
    val getMoviesUseCase: MoviesUseCase
) : ViewModel() {


var uiState by mutableStateOf(MoviesState())

    private var currentPage = 1



     fun getMovies(genresId: String,forceReload: Boolean = false) {
        if (uiState.loading) return
        if (forceReload) currentPage = 1

        viewModelScope.launch {
            uiState = uiState.copy(
                loading = true
            )
            try {
                val resultMovies = getMoviesUseCase(page = currentPage, genresId = genresId)
                val movies = if (currentPage == 1) resultMovies.moveList else uiState.movies + resultMovies.moveList

                currentPage += 1
                uiState = uiState.copy(
                    loading = false,
                    loadFinished = resultMovies.moveList.isEmpty(),
                    movies = movies
                )

            }catch (error: Throwable){
                uiState = uiState.copy(
                    loading = false,
                    loadFinished = true,
                    errorMessage = "Could not load movies: ${error.localizedMessage}"
                )
            }
        }

    }

}