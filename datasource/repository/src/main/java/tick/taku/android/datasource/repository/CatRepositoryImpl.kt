package tick.taku.android.datasource.repository

import android.util.Log
import tick.taku.android.core.entity.Breed
import tick.taku.android.core.entity.Cat
import tick.taku.android.core.entity.Url
import tick.taku.android.datasource.api.response.CatBreedResponse
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

    override suspend fun fetchCats(limit: Int): Result<List<Cat>> = apiCall {
        catService.fetchCatImages(limit).result { it.toEntity() }
    }

    private fun List<CatImageResponse>.toEntity() = map {
        Cat(
            id = it.id,
            url = Url(it.url),
            breeds = it.breeds?.toBreed().orEmpty()
        )
    }

    private fun List<CatBreedResponse>.toBreed() = map {
        when (it.name) {
            "Abyssinian" -> Breed.ABYSSINIAN
            "American Shorthair" -> Breed.AMERICAN_SHORT_HAIR
            "Bengal" -> Breed.BENGAL
            "Russian Blue" -> Breed.RUSSIAN_BLUE
            else -> Breed.OTHER
        }
    }
}