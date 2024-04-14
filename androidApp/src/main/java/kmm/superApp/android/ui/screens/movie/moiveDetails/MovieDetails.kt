
package kmm.superApp.android.ui.screens.movie.moiveDetails


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kmm.superApp.Constant
import kmm.superApp.android.ui.component.CoilImage
import kmm.superApp.android.ui.component.ErrorHolder
import kmm.superApp.android.ui.component.LoadingIndicator
import kmm.superApp.android.ui.component.TopBar
import kmm.superApp.android.utils.Routes


@Composable
fun DetailsScreen(
    mainNavController: NavHostController,
    movieDetailsViewModel: MovieDetailsViewModel,
) {



    if (movieDetailsViewModel.movie.value.isLoading) {
        LoadingIndicator()
    } else if (movieDetailsViewModel.movie.value.error.isNotEmpty()) {
        ErrorHolder(text = movieDetailsViewModel.movie.value.error)
    } else {
        val movie = movieDetailsViewModel.movie.value.movie
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            TopBar(
                title = "Details Screen",
                menu = {
                    IconButton(onClick = {
                        mainNavController.navigate(Routes().searchRoute)

                    }) {
                        Icon(Icons.Filled.Search, "search",tint = Color.White)
                    }
                }
            )
            CoilImage(
                data = Constant.imageBaseUrl + movie.posterUrl,
                contentDescription = movie.name ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movie.name ?: "",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = movie.tagline ?: "",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Release Date:${movie.releaseDate ?: ""}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Duration: ${movie.runtime ?: ""}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movie.overview ?: "",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Genres: ${movie.genres?.joinToString { it.name } ?: listOf("")}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Production Companies: ${movie.productionCompanies?.joinToString { it.name } ?: listOf("")}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }

    }


}