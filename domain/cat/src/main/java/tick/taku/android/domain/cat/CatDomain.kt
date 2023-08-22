package tick.taku.android.domain.cat

import kotlinx.coroutines.flow.Flow
import tick.taku.android.core.entity.Breed
import tick.taku.android.core.entity.Cat

interface CatDomain {
    fun cats(): Flow<List<Cat>>
    suspend fun fetch(): Result<Unit>
    suspend fun filterByBreed(breed: Breed): Result<Unit>
}