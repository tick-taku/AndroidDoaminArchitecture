package tick.taku.android.datasource.api.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import tick.taku.android.datasource.api.service.CatService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideCatService(retrofit: Retrofit): CatService {
        return retrofit.create(CatService::class.java)
    }
}