package com.nagyrobi144.dogify.usecase

import com.nagyrobi144.dogify.api.BreedsApi
import com.nagyrobi144.dogify.model.Breed
import com.nagyrobi144.dogify.repository.BreedsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import kotlin.native.concurrent.SharedImmutable
import kotlin.native.concurrent.ThreadLocal

class GetBreedsUseCase : KoinComponent {

    private val breedsRepository: BreedsRepository = get()

    suspend operator fun invoke(): List<Breed> = breedsRepository.get()
}