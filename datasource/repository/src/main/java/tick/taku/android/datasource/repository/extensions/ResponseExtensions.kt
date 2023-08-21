package tick.taku.android.datasource.repository.extensions

import retrofit2.Response
import tick.taku.android.datasource.repository.error.NetworkError

internal fun <R, T: Any> Response<T>.result(onSuccess: (T) -> R): R {
    return takeIf { isSuccessful }?.body()?.let { onSuccess(it) } ?: throw NetworkError(message())
}