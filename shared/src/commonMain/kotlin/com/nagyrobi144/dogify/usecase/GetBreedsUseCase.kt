package com.nagyrobi144.dogify.usecase

import com.nagyrobi144.dogify.model.Breed

class GetBreedsUseCase {

    suspend fun invoke(): List<Breed> = listOf(Breed("Test get", ""), )
}