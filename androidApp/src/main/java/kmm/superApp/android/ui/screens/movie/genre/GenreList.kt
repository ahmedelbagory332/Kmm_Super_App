package kmm.superApp.android.ui.screens.movie.genre


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kmm.superApp.android.ui.component.ErrorHolder
import kmm.superApp.android.ui.component.LoadingIndicator
import kmm.superApp.android.ui.component.PlaceHolder
import kmm.superApp.android.ui.screens.movie.genre.widget.Chip
import kmm.superApp.android.ui.screens.movie.movies.MovieList
import kmm.superApp.android.ui.screens.movie.movies.MoviesViewModel
import kmm.superApp.domain.entity.GenreItemModel
import kmm.superApp.domain.entity.MovieItem
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenreList(
    genreViewModel: GenreViewModel = koinViewModel(),
    moviesViewModel: MoviesViewModel = koinViewModel(),
    onMovieClick: (MovieItem) -> Unit
) {


    if (genreViewModel.genres.value.isLoading) {
        LoadingIndicator()
    } else if (genreViewModel.genres.value.genre.isNotEmpty()) {
        Text(
            modifier = Modifier.padding(PaddingValues(8.dp)),
            text = "Movie Category : ",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        LazyRow {
            items(genreViewModel.genres.value.genre) { genre ->
                Chip(
                    genre = genre,
                    selected = genreViewModel.selectedGenre.value == genre,
                    onSelected = {
                        if (genreViewModel.selectedGenre.value == genre)
                            genreViewModel.setSelectedGenre(GenreItemModel())
                        else {
                            genreViewModel.setSelectedGenre(genre)

                            moviesViewModel.getMovies(
                                genreViewModel.selectedGenre.value.id.toString(),
                                true
                            )
                        }

                    },
                    modifier = Modifier
                )
            }
        }
        if (genreViewModel.selectedGenre.value.name.isNotEmpty()) {
            MovieList(
                moviesViewModel = moviesViewModel,
                genresId = genreViewModel.selectedGenre.value.id.toString(),
                onMovieClick = onMovieClick

            )
        } else {
            PlaceHolder(
                text = "Please select category",
                painter = painterResource(id = kmm.superApp.R.drawable.select)
            )
        }

    } else if (genreViewModel.genres.value.error.isNotEmpty()) {
        ErrorHolder(text = genreViewModel.genres.value.error ?: "An unexpected error happened")
    }

}