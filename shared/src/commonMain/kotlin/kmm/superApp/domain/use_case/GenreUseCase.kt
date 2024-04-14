package kmm.superApp.domain.use_case

import kmm.superApp.domain.entity.GenreModel
import kmm.superApp.domain.repo.MoviesRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GenreUseCase : KoinComponent {

    private val moviesRepo: MoviesRepo by inject()

    suspend operator fun invoke(): GenreModel {
        return moviesRepo.getRemoteGenre()
    }

}