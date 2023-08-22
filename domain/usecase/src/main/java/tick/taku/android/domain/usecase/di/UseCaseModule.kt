package tick.taku.android.domain.usecase.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import tick.taku.android.domain.usecase.FilterByBreedUseCase
import tick.taku.android.domain.usecase.FilterByBreedUseCaseImpl

@InstallIn(ViewModelComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun FilterByBreedUseCaseImpl.bindFilterByBreedUseCase(): FilterByBreedUseCase
}