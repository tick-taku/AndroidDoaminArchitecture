package tick.taku.android.domain.cat.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import tick.taku.android.domain.cat.CatDomain
import tick.taku.android.domain.cat.CatDomainImpl

@InstallIn(ActivityComponent::class)
@Module
abstract class CatDomainModule {

    @Binds
    abstract fun CatDomainImpl.bindCatDomain(): CatDomain
}