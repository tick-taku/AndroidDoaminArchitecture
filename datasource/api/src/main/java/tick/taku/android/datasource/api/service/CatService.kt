package tick.taku.android.datasource.api.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import tick.taku.android.datasource.api.response.CatImageResponse

interface CatService {

    @GET("https://api.thecatapi.com/v1/images/search")
    suspend fun fetchCatImages(@Query("limit") limit: Int): Response<CatImageResponse>
}