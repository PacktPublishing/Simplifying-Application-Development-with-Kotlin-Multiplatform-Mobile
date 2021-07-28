package com.nagyrobi144.dogify.repository

import com.nagyrobi144.dogify.db.DogifyDatabase
import com.nagyrobi144.dogify.model.Breed
import com.nagyrobi144.dogify.util.DispatcherProvider
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class DefaultBreedsLocalSource(
    database: DogifyDatabase,
    private val dispatcherProvider: DispatcherProvider
): BreedsLocalSource {
    private val dao = database.breedsQueries

    override val breeds = dao.selectAll().asFlow().mapToList()
        .map { breeds -> breeds.map { Breed(it.name, it.imageUrl, it.isFavourite ?: false) } }

    override suspend fun selectAll() = withContext(dispatcherProvider.io) {
        dao.selectAll { name, imageUrl, isFavourite -> Breed(name, imageUrl, isFavourite ?: false) }
            .executeAsList()
    }

    override suspend fun insert(breed: Breed) = withContext(dispatcherProvider.io) {
        dao.insert(breed.name, breed.imageUrl, breed.isFavourite)
    }

    override suspend fun update(breed: Breed) = withContext(dispatcherProvider.io) {
        dao.update(breed.imageUrl, breed.isFavourite, breed.name)
    }

    override suspend fun clear() = withContext(dispatcherProvider.io) {
        dao.clear()
    }
}