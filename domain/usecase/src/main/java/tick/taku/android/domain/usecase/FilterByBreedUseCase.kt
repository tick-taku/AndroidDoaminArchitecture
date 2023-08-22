package tick.taku.android.domain.usecase

import tick.taku.android.core.entity.Breed
import tick.taku.android.core.entity.Cat

interface FilterByBreedUseCase {
    suspend operator fun invoke(cats: List<Cat>, breed: Breed): List<Cat>
}