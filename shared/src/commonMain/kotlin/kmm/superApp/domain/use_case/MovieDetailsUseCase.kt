package kmm.superApp.domain.use_case

import kmm.superApp.domain.entity.MovieDetailsModel
import kmm.superApp.domain.repo.MoviesRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MovieDetailsUseCase : KoinComponent {

    private val moviesRepo: MoviesRepo by inject()

    suspend operator fun invoke(id: String): MovieDetailsModel {
        return moviesRepo.getRemoteMovieDetails(id)
    }

}