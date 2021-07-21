package com.nagyrobi144.dogify.repository

import com.nagyrobi144.dogify.model.Breed
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.supervisorScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BreedsRepository: KoinComponent {

    private val remoteSource: BreedsRemoteSource by inject()
    private val localSource: BreedsLocalSource by inject()

    val breeds = localSource.breeds

    internal suspend fun get() = with(localSource.selectAll()) {
        if (isNullOrEmpty()) {
            return@with fetch()
        } else {
            this
        }
    }

    internal suspend fun fetch() = supervisorScope {
        remoteSource.getBreeds().map {
            async { Breed(name = it, imageUrl = remoteSource.getBreedImage(it)) }
        }.awaitAll().also {
            localSource.clear()
            it.map { async { localSource.insert(it) } }.awaitAll()
        }
    }

    suspend fun update(breed: Breed) = localSource.update(breed)
}