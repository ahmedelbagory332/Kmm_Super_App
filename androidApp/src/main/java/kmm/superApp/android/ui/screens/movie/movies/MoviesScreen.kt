package kmm.superApp.android.ui.screens.movie.movies


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import kmm.superApp.android.ui.component.TopBar
import kmm.superApp.android.ui.screens.movie.genre.GenreList
import kmm.superApp.android.utils.Routes


@SuppressLint(
    "UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter",
    "UnusedMaterial3ScaffoldPaddingParameter"
)
@Composable
fun MoviesScreen(
    mainNavController: NavHostController,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()

    ) {

        TopBar(
            title = "Movies Screen",
            menu = {
                IconButton(onClick = {
                    mainNavController.navigate(Routes().searchRoute)
                }) {
                    Icon(Icons.Filled.Search, "search", tint = Color.White)
                }
            }
        )
        GenreList(
            onMovieClick = {
                mainNavController.navigate(Routes().detailsRoute + "/${it.id}")
            })

    }


}