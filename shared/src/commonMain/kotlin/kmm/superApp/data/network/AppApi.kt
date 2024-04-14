package kmm.superApp.data.network


import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.appendPathSegments
import kmm.superApp.Constant.ApiKey
import kmm.superApp.Constant.launchBaseUrl
import kmm.superApp.Constant.movieBaseUrl
import kmm.superApp.data.dto.GenreDto
import kmm.superApp.data.dto.MovieDetailsDto
import kmm.superApp.data.dto.MovieDto
import kmm.superApp.data.dto.RocketLaunch

class AppApi(private val client: HttpClient) {


    suspend fun getAllLaunches() = client.get("$launchBaseUrl/launches").body<List<RocketLaunch>>()

    suspend fun getGenres() = client.get("$movieBaseUrl/genre/movie/list") {
        parameter("api_key", ApiKey)
    }.body<GenreDto>()

    suspend fun getMovies(
        genresId: String,
        page: Int,
    ) = client.get("$movieBaseUrl/discover/movie") {
        parameter("api_key", ApiKey)
        parameter("page", page)
        parameter("with_genres", genresId)
    }.body<MovieDto>()

    suspend fun getMovieDetails(id: String) = client.get("$movieBaseUrl/movie") {
        url {
            appendPathSegments( id)
        }
        parameter("api_key", ApiKey)
    }.body<MovieDetailsDto>()

    suspend fun getSearchMovies(
        query: String,
        page: Int,
    ) = client.get("$movieBaseUrl/search/movie") {
        parameter("api_key", ApiKey)
        parameter("page", page)
        parameter("query", query)
    }.body<MovieDto>()


}