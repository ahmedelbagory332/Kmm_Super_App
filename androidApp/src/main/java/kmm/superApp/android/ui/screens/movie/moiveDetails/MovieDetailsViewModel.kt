package kmm.superApp.android.ui.screens.movie.moiveDetails



import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kmm.superApp.domain.use_case.MovieDetailsUseCase
import kotlinx.coroutines.launch


class MovieDetailsViewModel constructor(
    val getMovieDetailsUseCase: MovieDetailsUseCase,
    movieId:String
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailsState())

    val movie: State<MovieDetailsState>
        get() = _state

    init {
        getMovie(movieId)
    }

     private fun getMovie(movieId:String) {
        viewModelScope.launch {
            try {
                _state.value = MovieDetailsState(isLoading = true)
                val result = getMovieDetailsUseCase(id = movieId)
                _state.value = MovieDetailsState(movie = result)
            } catch (e: Exception) {
                _state.value = MovieDetailsState(
                    error = e.message ?: "An unexpected error happened"
                )

            }
        }

    }


}