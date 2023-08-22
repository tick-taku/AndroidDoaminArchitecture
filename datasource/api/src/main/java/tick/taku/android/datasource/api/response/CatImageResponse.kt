package tick.taku.android.datasource.api.response

import kotlinx.serialization.Serializable

@Serializable
data class CatImageResponse(
    val id: String,
    val url: String,
    val breeds: List<CatBreedResponse>? = null
)

@Serializable
data class CatBreedResponse(
    val name: String
)