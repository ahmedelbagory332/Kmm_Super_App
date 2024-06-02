package kmm.superApp.android.ui.screens.movie.movies


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import kmm.superApp.android.ui.component.ErrorHolder
import kmm.superApp.android.ui.component.LoadingIndicator
import kmm.superApp.android.ui.screens.movie.movies.widget.MovieListItem
import kmm.superApp.domain.entity.MovieItem

@Composable
@ExperimentalMaterial3Api
fun MovieList(
    moviesViewModel: MoviesViewModel,
    genresId: String,
    onMovieClick: (MovieItem) -> Unit

) {
    val uiState = moviesViewModel.uiState


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)

    ) {
        if (uiState.loading && uiState.movies.isEmpty()) {
            LoadingIndicator()
        } else if (uiState.errorMessage.isNotEmpty()) {
            ErrorHolder(text = uiState.errorMessage)
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(
                    uiState.movies,
                    key = { _, movie -> movie.id }
                ) { index, movie ->
                    MovieListItem(movie = movie) {
                        onMovieClick(movie)
                    }

                    if (index >= uiState.movies.size - 1 && !uiState.loading && !uiState.loadFinished) {
                        LaunchedEffect(
                            key1 = Unit,
                            block = {
                                moviesViewModel.sendIntent(MoviesIntent.GetMovies(genresId, false))
                            })
                    }
                }

                if (uiState.loading && uiState.movies.isNotEmpty()) {
                    item(span = { GridItemSpan(2) }) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(
                                color = Red
                            )
                        }
                    }
                }
            }

        }
    }
}
















