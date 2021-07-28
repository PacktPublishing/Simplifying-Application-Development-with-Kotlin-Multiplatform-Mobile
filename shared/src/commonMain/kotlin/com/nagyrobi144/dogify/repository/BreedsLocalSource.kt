package com.nagyrobi144.dogify.repository

import com.nagyrobi144.dogify.model.Breed
import kotlinx.coroutines.flow.Flow

interface BreedsLocalSource {

    val breeds: Flow<List<Breed>>

    suspend fun selectAll(): List<Breed>

    suspend fun insert(breed: Breed)

    suspend fun update(breed: Breed)

    suspend fun clear()
}