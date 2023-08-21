package tick.taku.android.datasource.api.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import tick.taku.android.datasource.api.response.CatImageResponse

interface CatService {

    @Headers("x-api-key: apiKey")
    @GET("/v1/images/search")
    suspend fun fetchCatImages(@Query("limit") limit: Int): Response<List<CatImageResponse>>
}