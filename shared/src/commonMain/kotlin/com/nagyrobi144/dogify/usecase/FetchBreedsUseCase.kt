package com.nagyrobi144.dogify.usecase

import com.nagyrobi144.dogify.model.Breed
import com.nagyrobi144.dogify.repository.BreedsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FetchBreedsUseCase : KoinComponent {

    private val breedsRepository: BreedsRepository by inject()

    suspend operator fun invoke(): List<Breed> = breedsRepository.fetch()
}