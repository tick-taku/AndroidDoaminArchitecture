package tick.taku.android.domain.cat.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import tick.taku.android.domain.cat.CatDomain
import tick.taku.android.domain.cat.CatDomainImpl

@InstallIn(ViewModelComponent::class)
@Module
abstract class CatDomainModule {

    @Binds
    abstract fun CatDomainImpl.bindCatDomain(): CatDomain
}