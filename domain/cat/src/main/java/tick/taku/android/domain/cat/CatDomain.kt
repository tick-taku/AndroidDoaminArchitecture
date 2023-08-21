package tick.taku.android.domain.cat

import kotlinx.coroutines.flow.Flow
import tick.taku.android.core.entity.Cat

interface CatDomain {
    suspend fun cats(): Flow<List<Cat>>
    suspend fun fetch()
}