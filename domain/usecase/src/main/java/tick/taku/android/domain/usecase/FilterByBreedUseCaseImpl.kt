package tick.taku.android.domain.usecase

import tick.taku.android.core.entity.Breed
import tick.taku.android.core.entity.Cat
import javax.inject.Inject

class FilterByBreedUseCaseImpl @Inject internal constructor(): FilterByBreedUseCase {

    override suspend operator fun invoke(cats: List<Cat>, breed: Breed): List<Cat> {
        return cats.filter { it.breeds.contains(breed) }
    }
}