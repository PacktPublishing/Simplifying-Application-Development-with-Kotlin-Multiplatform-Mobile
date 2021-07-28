package com.nagyrobi144.dogify

import com.nagyrobi144.dogify.model.Breed
import com.nagyrobi144.dogify.repository.BreedsRemoteSource

class FakeBreedsRemoteSource : BreedsRemoteSource {

    private val data = mutableMapOf<String, String?>(
        breed1.name to breed1.imageUrl,
        breed2.name to breed2.imageUrl
    )

    override suspend fun getBreeds() = data.keys.toList()

    override suspend fun getBreedImage(breed: String) = data[breed]!!

}

val breed1 = Breed("vizsla", "vizsla-url")
val breed2 = Breed("kuvasz", "kuvasz-url")