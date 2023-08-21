package tick.taku.android.domain.cat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onStart
import tick.taku.android.core.entity.Cat
import tick.taku.android.datasource.repository.CatRepository
import javax.inject.Inject

class CatDomainImpl @Inject internal constructor(
    private val catRepository: CatRepository
): CatDomain {

    private companion object {
        const val IMAGE_LIMIT = 20
    }

    private val catsFlow = MutableStateFlow<List<Cat>>(emptyList())

    override fun cats(): Flow<List<Cat>> = catsFlow.onStart {
        if (catsFlow.value.isEmpty()) fetch()
    }

    override suspend fun fetch(): Result<Unit> {
        return catRepository.fetchCats(IMAGE_LIMIT).onSuccess { catsFlow.value = it }.map {}
    }
}