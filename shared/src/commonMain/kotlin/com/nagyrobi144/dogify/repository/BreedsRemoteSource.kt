package com.nagyrobi144.dogify.repository

interface BreedsRemoteSource {

    suspend fun getBreeds(): List<String>

    suspend fun getBreedImage(breed: String): String
}