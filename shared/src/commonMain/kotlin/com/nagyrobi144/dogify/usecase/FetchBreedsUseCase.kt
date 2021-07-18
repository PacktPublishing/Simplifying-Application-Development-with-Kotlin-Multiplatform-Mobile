package com.nagyrobi144.dogify.usecase

import com.nagyrobi144.dogify.model.Breed

class FetchBreedsUseCase {

    suspend fun invoke(): List<Breed> = listOf(Breed("Test fetch", ""))
}