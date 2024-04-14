package kmm.superApp.data.dto

import kotlinx.serialization.Serializable


@Serializable
data class GenreDto(
    val genres: ArrayList<GenreItemDto>,
)

@Serializable
data class GenreItemDto(
    val id: Long,
    val name: String,
)
