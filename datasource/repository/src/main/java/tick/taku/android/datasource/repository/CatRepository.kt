package tick.taku.android.datasource.repository

import tick.taku.android.core.entity.Cat

interface CatRepository {
    suspend fun fetchCats(limit: Int): Result<List<Cat>>
}