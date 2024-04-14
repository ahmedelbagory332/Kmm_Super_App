package kmm.superApp.domain.repo

import kmm.superApp.domain.entity.GenreModel
import kmm.superApp.domain.entity.MovieDetailsModel
import kmm.superApp.domain.entity.MovieModel

interface MoviesRepo {

    suspend fun getRemoteGenre(): GenreModel
    suspend fun getRemoteMovieDetails(movieId: String): MovieDetailsModel
    suspend fun getRemoteSearchMovie(page: Int, movieName: String): MovieModel
    suspend fun getRemoteMovie(page: Int, genresId: String): MovieModel

}