package tick.taku.android.datasource.repository

import tick.taku.android.core.entity.Cat
import tick.taku.android.core.entity.Url
import tick.taku.android.datasource.api.response.CatImageResponse
import tick.taku.android.datasource.api.service.CatService
import tick.taku.android.datasource.repository.extensions.apiCall
import tick.taku.android.datasource.repository.extensions.result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatRepositoryImpl @Inject internal constructor(
    private val catService: CatService
): CatRepository {

    override suspend fun fetchCats(limit: Int): Result<Cat> = apiCall {
        catService.fetchCatImages(limit).result { it.toEntity() }
    }

    private fun CatImageResponse.toEntity() = Cat(
        id = id,
        url = Url(url)
    )
}