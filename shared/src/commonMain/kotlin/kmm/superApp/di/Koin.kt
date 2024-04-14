package kmm.superApp.di

import data.cache.LocalDatabase
import kmm.superApp.data.network.AppApi
import kmm.superApp.data.repo_impl.LaunchesRepoImpl
import kmm.superApp.data.repo_impl.MoviesRepoImpl
import kmm.superApp.domain.mapper.MovieMapper
import kmm.superApp.domain.repo.LaunchesRepo
import kmm.superApp.domain.repo.MoviesRepo
import kmm.superApp.domain.use_case.GenreUseCase
import kmm.superApp.domain.use_case.HomeUseCase
import kmm.superApp.domain.use_case.LaunchesUseCase
import kmm.superApp.domain.use_case.MovieDetailsUseCase
import kmm.superApp.domain.use_case.MoviesUseCase
import kmm.superApp.domain.use_case.SearchMoviesUseCase
import kmm.superApp.platformModule
import org.koin.core.context.startKoin
import org.koin.dsl.module


fun initKoin() =
    startKoin {
        modules(commonModule(), platformModule())
    }


fun commonModule() = module {
    single{ createJson() }
    single { createHttpClient(get(), get()) }
    single{ AppApi(get()) }
    single{ LocalDatabase() }
    single<LaunchesRepo> { LaunchesRepoImpl(get()) }
    single{ LaunchesUseCase() }
    single{ HomeUseCase() }
    single<MovieMapper> { MovieMapper() }
    single<MoviesRepo> { MoviesRepoImpl(get(),get()) }
    single{ MoviesUseCase() }
    single{ MovieDetailsUseCase() }
    single{ SearchMoviesUseCase() }
    single{ GenreUseCase() }


}






