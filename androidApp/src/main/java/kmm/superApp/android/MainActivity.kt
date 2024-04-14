package kmm.superApp.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kmm.superApp.android.ui.screens.home.HomeScreen
import kmm.superApp.android.ui.screens.movie.moiveDetails.DetailsScreen
import kmm.superApp.android.ui.screens.movie.moiveDetails.MovieDetailsViewModel
import kmm.superApp.android.ui.screens.movie.movies.MoviesScreen
import kmm.superApp.android.ui.screens.spaceLaunches.LaunchesScreen
import kmm.superApp.android.utils.Routes
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()


        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun App() {
    val mainNavController = rememberNavController()

    NavHost(
        navController = mainNavController,
        startDestination = Routes().mainRoute
    ) {

        composable(route = Routes().mainRoute) {
            HomeScreen(mainNavController)
        }
        composable(route = Routes().launchesRoute) {
            LaunchesScreen(mainNavController)
        }
        composable(route = Routes().moviesRoute) {
            MoviesScreen(mainNavController)
        }
        composable(route = Routes().detailsRoute + "/{movieId}") {
            val movieId = it.arguments?.getString("movieId")
            val detailViewModel: MovieDetailsViewModel = koinViewModel(
                parameters = { parametersOf(movieId) }
            )
            DetailsScreen(mainNavController,detailViewModel)
        }

    }


}