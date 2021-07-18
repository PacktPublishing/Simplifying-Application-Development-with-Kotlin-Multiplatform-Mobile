package com.nagyrobi144.dogify.api

import com.nagyrobi144.dogify.api.model.BreedImageResponse
import com.nagyrobi144.dogify.api.model.BreedsResponse
import io.ktor.client.request.*
import kotlin.collections.get

/**
 * Ktor Networking Api for getting information about a Breed entity
 */
internal class BreedsApi : KtorApi() {

    suspend fun getBreeds(): BreedsResponse = client.get {
        apiUrl("breeds/list")
    }

    suspend fun getRandomBreedImageFor(breed: String): BreedImageResponse = client.get {
        apiUrl("breed/$breed/images/random")
    }
}