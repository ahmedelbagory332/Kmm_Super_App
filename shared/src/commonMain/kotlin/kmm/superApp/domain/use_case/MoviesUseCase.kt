package kmm.superApp.domain.use_case

import kmm.superApp.domain.entity.MovieModel
import kmm.superApp.domain.repo.MoviesRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MoviesUseCase : KoinComponent {

    private val moviesRepo: MoviesRepo by inject()

    suspend operator fun invoke(page: Int, genresId: String): MovieModel {
        return moviesRepo.getRemoteMovie(page, genresId)
    }

}