package tick.taku.android.datasource.api.response

import kotlinx.serialization.Serializable

@Serializable
data class CatImageResponse(
    val id: Int,
    val url: String
)