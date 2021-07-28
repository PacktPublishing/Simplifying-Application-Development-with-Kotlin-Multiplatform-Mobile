package com.nagyrobi144.dogify

import com.nagyrobi144.dogify.model.Breed
import com.nagyrobi144.dogify.repository.BreedsLocalSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeBreedsLocalSource : BreedsLocalSource {

    private val _breeds = MutableStateFlow<List<Breed>>(emptyList())

    override val breeds: Flow<List<Breed>>
        get() = _breeds

    override suspend fun selectAll(): List<Breed> = _breeds.value

    override suspend fun insert(breed: Breed) {
        _breeds.value = _breeds.value + breed
    }

    override suspend fun update(breed: Breed) {
        _breeds.value = _breeds.value.map {
            if (it.name == breed.name) {
                breed
            } else {
                it
            }
        }
    }

    override suspend fun clear() {
        _breeds.value = emptyList()
    }
}