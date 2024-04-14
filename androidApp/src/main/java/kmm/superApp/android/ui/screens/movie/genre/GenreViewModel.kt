package kmm.superApp.android.ui.screens.movie.genre


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kmm.superApp.domain.entity.GenreItemModel
import kmm.superApp.domain.use_case.GenreUseCase
import kotlinx.coroutines.launch


class GenreViewModel constructor(
    val getGenreUseCase: GenreUseCase
) : ViewModel() {

    private val _state = mutableStateOf(GenreState())
    private var _selectedGenre = mutableStateOf(GenreItemModel())

    val genres: State<GenreState>
        get() = _state

    val selectedGenre: State<GenreItemModel>
        get() = _selectedGenre

    fun setSelectedGenre(selectedGenre: GenreItemModel) {
        _selectedGenre.value = selectedGenre
        _selectedGenre.value = _selectedGenre.value
    }

    init {
        getGenre()
    }

    private fun getGenre() {
        viewModelScope.launch {
            try {
                _state.value = GenreState(isLoading = true)
                val result = getGenreUseCase()
                _state.value = GenreState(genre = result.genres)
            } catch (e: Exception) {

                _state.value = GenreState(
                    error = e.message ?: "An unexpected error happened"
                )

            }
        }

    }

}