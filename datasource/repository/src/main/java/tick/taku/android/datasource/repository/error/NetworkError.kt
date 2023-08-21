package tick.taku.android.datasource.repository.error

data class NetworkError(override val message: String?): Throwable()