package kmm.superApp.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsDto(
    val adult: Boolean,
    @SerialName("backdrop_path")
    val backdropPath: String,
    @SerialName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection?,
    val budget: Long,
    val genres: List<GenreMovieDetailsDto>,
    val homepage: String,
    val id: Long,
    @SerialName("imdb_id")
    val imdbId: String,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompanyDto>,
    @SerialName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerialName("release_date")
    val releaseDate: String,
    val revenue: Long,
    val runtime: Long,
    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerialName("vote_average")
    val voteAverage: Double,
    @SerialName("vote_count")
    val voteCount: Long,
)

@Serializable
data class BelongsToCollection(
    val id: Long,
    val name: String,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("backdrop_path")
    val backdropPath: String,
)

@Serializable
data class GenreMovieDetailsDto(
    val id: Long,
    val name: String,
)

@Serializable
data class ProductionCompanyDto(
    val id: Long,
    @SerialName("logo_path")
    val logoPath: String?,
    val name: String,
    @SerialName("origin_country")
    val originCountry: String,
)

@Serializable
data class ProductionCountry(
    @SerialName("iso_3166_1")
    val iso31661: String,
    val name: String,
)

@Serializable
data class SpokenLanguage(
    @SerialName("english_name")
    val englishName: String,
    @SerialName("iso_639_1")
    val iso6391: String,
    val name: String,
)
