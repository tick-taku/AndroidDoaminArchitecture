package tick.taku.android.datasource.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tick.taku.android.datasource.repository.CatRepository
import tick.taku.android.datasource.repository.CatRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun CatRepositoryImpl.bindCatRepository(): CatRepository
}