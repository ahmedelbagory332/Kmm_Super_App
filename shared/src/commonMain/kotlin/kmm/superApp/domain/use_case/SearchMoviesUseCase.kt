package kmm.superApp.domain.use_case

import kmm.superApp.domain.entity.MovieModel
import kmm.superApp.domain.repo.MoviesRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchMoviesUseCase : KoinComponent {

    private val moviesRepo: MoviesRepo by inject()

    suspend operator fun invoke(page: Int, movieName: String): MovieModel {
        return moviesRepo.getRemoteSearchMovie(page, movieName)
    }

}