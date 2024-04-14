package kmm.superApp.android.di

import kmm.superApp.android.ui.screens.home.HomeViewModel
import kmm.superApp.android.ui.screens.movie.genre.GenreViewModel
import kmm.superApp.android.ui.screens.movie.moiveDetails.MovieDetailsViewModel
import kmm.superApp.android.ui.screens.movie.movies.MoviesViewModel
import kmm.superApp.android.ui.screens.spaceLaunches.LaunchesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LaunchesViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { GenreViewModel(get()) }
    viewModel { MoviesViewModel(get()) }
    viewModel { params ->MovieDetailsViewModel(get(),params.get()) }
}