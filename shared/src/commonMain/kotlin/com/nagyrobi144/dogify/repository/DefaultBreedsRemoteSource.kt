package com.nagyrobi144.dogify.repository

import com.nagyrobi144.dogify.api.BreedsApi
import com.nagyrobi144.dogify.util.DispatcherProvider
import kotlinx.coroutines.withContext

internal class DefaultBreedsRemoteSource(
    private val api: BreedsApi,
    private val dispatcherProvider: DispatcherProvider
): BreedsRemoteSource {

    override suspend fun getBreeds() = withContext(dispatcherProvider.io) {
        api.getBreeds().breeds
    }

    override suspend fun getBreedImage(breed: String) = withContext(dispatcherProvider.io) {
        api.getRandomBreedImageFor(breed).breedImageUrl
    }
}