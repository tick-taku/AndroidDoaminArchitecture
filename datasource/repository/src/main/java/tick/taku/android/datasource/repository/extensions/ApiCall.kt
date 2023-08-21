package tick.taku.android.datasource.repository.extensions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal suspend inline fun <T> apiCall(crossinline call: suspend () -> T): Result<T> = withContext(
    Dispatchers.IO) {
    runCatching { call() }
}