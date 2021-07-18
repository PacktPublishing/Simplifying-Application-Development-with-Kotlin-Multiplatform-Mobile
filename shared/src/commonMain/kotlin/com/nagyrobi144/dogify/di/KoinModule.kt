package com.nagyrobi144.dogify.di

import com.nagyrobi144.dogify.api.BreedsApi
import com.nagyrobi144.dogify.database.createDriver
import com.nagyrobi144.dogify.db.DogifyDatabase
import com.nagyrobi144.dogify.repository.BreedsLocalSource
import com.nagyrobi144.dogify.repository.BreedsRemoteSource
import com.nagyrobi144.dogify.repository.BreedsRepository
import com.nagyrobi144.dogify.usecase.FetchBreedsUseCase
import com.nagyrobi144.dogify.usecase.GetBreedsUseCase
import com.nagyrobi144.dogify.usecase.ToggleFavouriteStateUseCase
import com.nagyrobi144.dogify.util.getDispatcherProvider
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

private val utilityModule = module {
    factory { getDispatcherProvider() }
    single { DogifyDatabase(createDriver("dogify.db")) }
}

private val apiModule = module {
    factory { BreedsApi() }
}

private val repositoryModule = module {
    single { BreedsRepository(get(), get()) }

    factory { BreedsRemoteSource(get(), get()) }
    factory { BreedsLocalSource(get(), get()) }
}

private val usecaseModule = module {
    factory { GetBreedsUseCase() }
    factory { FetchBreedsUseCase() }
    factory { ToggleFavouriteStateUseCase() }
}

private val sharedModules = listOf(usecaseModule, repositoryModule, apiModule, utilityModule)

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(sharedModules)
}