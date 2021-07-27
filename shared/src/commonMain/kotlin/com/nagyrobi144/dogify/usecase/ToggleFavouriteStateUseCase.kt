package com.nagyrobi144.dogify.usecase

import com.nagyrobi144.dogify.model.Breed
import com.nagyrobi144.dogify.repository.BreedsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject

class ToggleFavouriteStateUseCase: KoinComponent {

    private val breedsRepository: BreedsRepository = get()

    suspend operator fun invoke(breed: Breed){
        breedsRepository.update(breed.copy(isFavourite = !breed.isFavourite))
    }
}