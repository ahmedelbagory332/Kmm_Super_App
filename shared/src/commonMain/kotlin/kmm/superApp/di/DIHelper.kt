package kmm.superApp.di

import kmm.superApp.domain.use_case.GenreUseCase
import kmm.superApp.domain.use_case.HomeUseCase
import kmm.superApp.domain.use_case.LaunchesUseCase
import kmm.superApp.domain.use_case.MovieDetailsUseCase
import kmm.superApp.domain.use_case.MoviesUseCase
import kmm.superApp.domain.use_case.SearchMoviesUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

// This class is used for injecting in the iOS

class DIHelper : KoinComponent {
    val launchesUseCase: LaunchesUseCase by inject()
    val homeUseCase: HomeUseCase by inject()
    val moviesUseCase: MoviesUseCase by inject()
    val movieDetailsUseCase: MovieDetailsUseCase by inject()
    val searchMoviesUseCase: SearchMoviesUseCase by inject()
    val genreUseCase: GenreUseCase by inject()

}