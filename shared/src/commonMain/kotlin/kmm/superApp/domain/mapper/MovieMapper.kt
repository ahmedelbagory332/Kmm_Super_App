package kmm.superApp.domain.mapper


import kmm.superApp.data.dto.GenreDto
import kmm.superApp.data.dto.GenreItemDto
import kmm.superApp.data.dto.GenreMovieDetailsDto
import kmm.superApp.data.dto.MovieDetailsDto
import kmm.superApp.data.dto.MovieDto
import kmm.superApp.data.dto.MovieItemDto
import kmm.superApp.data.dto.ProductionCompanyDto
import kmm.superApp.domain.entity.Genre
import kmm.superApp.domain.entity.GenreItemModel
import kmm.superApp.domain.entity.GenreModel
import kmm.superApp.domain.entity.MovieDetailsModel
import kmm.superApp.domain.entity.MovieItem
import kmm.superApp.domain.entity.MovieModel
import kmm.superApp.domain.entity.ProductionCompany

class MovieMapper  {



    fun fromRemoteGenreToGenreModel(obj: GenreDto): GenreModel {
        return GenreModel(
            genres = obj.genres.map {
                fromRemoteItemGenreToItemGenreMode(it)
            }
        )

    }


    private fun fromRemoteItemGenreToItemGenreMode(obj: GenreItemDto): GenreItemModel {
        return GenreItemModel(
            id = obj.id,
            name = obj.name,
        )
    }


    fun fromRemoteMoviesToMoviesModel(obj: MovieDto): MovieModel {
        return MovieModel(
            moveList = fromRemoteMovieItemDtoToMovieItem(obj.moveList),
            page = obj.page,
            totalPages = obj.totalPages,
            totalResults = obj.totalResults
        )

    }

    private fun fromRemoteMovieItemDtoToMovieItem(obj: List<MovieItemDto>): List<MovieItem> {
        return obj.map {
            MovieItem(
                id = it.id,
                posterUrl = it.posterPath,
                name = it.title,
            )
        }

    }





    fun fromRemoteMovieDetailsToMovieDetailsModel(obj: MovieDetailsDto): MovieDetailsModel {
        return MovieDetailsModel(
            id = obj.id,
            posterUrl = obj.backdropPath,
            name = obj.originalTitle,
            tagline = obj.tagline,
            releaseDate = obj.releaseDate,
            runtime = obj.runtime,
            overview = obj.overview,
            genres = fromRemoteGenreMovieDetailsDtoToItemGenre(obj.genres),
            productionCompanies = fromRemoteProductionCompanyDtoToProductionCompany(obj.productionCompanies),

            )


    }

    private fun fromRemoteGenreMovieDetailsDtoToItemGenre(obj: List<GenreMovieDetailsDto>): List<Genre> {
        return obj.map {
            Genre(
                id = it.id,
                name = it.name,
            )
        }

    }

    private fun fromRemoteProductionCompanyDtoToProductionCompany(obj: List<ProductionCompanyDto>): List<ProductionCompany> {
        return obj.map {
            ProductionCompany(
                id = it.id,
                name = it.name,
                logoPath = it.logoPath?: "",
                originCountry = it.originCountry,
            )
        }

    }



}