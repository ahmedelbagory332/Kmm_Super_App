package kmm.superApp.data.repo_impl

import kmm.superApp.data.network.AppApi
import kmm.superApp.domain.entity.GenreModel
import kmm.superApp.domain.entity.MovieDetailsModel
import kmm.superApp.domain.entity.MovieModel
import kmm.superApp.domain.mapper.MovieMapper
import kmm.superApp.domain.repo.MoviesRepo

class MoviesRepoImpl(private val api: AppApi, private val movieMapper: MovieMapper) : MoviesRepo {


    override suspend fun getRemoteGenre(): GenreModel {
        return movieMapper.fromRemoteGenreToGenreModel(api.getGenres())
    }

    override suspend fun getRemoteMovieDetails(movieId: String): MovieDetailsModel {
        return movieMapper.fromRemoteMovieDetailsToMovieDetailsModel(api.getMovieDetails(movieId))
    }

    override suspend fun getRemoteSearchMovie(page: Int, movieName: String): MovieModel {
        return movieMapper.fromRemoteMoviesToMoviesModel(api.getSearchMovies(movieName, page))
    }

    override suspend fun getRemoteMovie(page: Int, genresId: String): MovieModel {
        return movieMapper.fromRemoteMoviesToMoviesModel(
            api.getMovies(
                genresId = genresId,
                page = page
            )
        )
    }
}