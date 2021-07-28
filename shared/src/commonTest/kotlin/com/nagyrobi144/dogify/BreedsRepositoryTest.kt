package com.nagyrobi144.dogify

import com.nagyrobi144.dogify.di.initKoin
import com.nagyrobi144.dogify.repository.BreedsLocalSource
import com.nagyrobi144.dogify.repository.BreedsRemoteSource
import com.nagyrobi144.dogify.repository.BreedsRepository
import kotlinx.coroutines.flow.first
import org.koin.dsl.module
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class BreedsRepositoryTest {

    private lateinit var sut: BreedsRepository

    @BeforeTest
    fun setup() {
        initKoin {
            modules(module {
                single<BreedsLocalSource> { FakeBreedsLocalSource() }
                factory<BreedsRemoteSource> { FakeBreedsRemoteSource() }
            })
        }

        sut = BreedsRepository()
    }


    @Test
    fun `When get is called Then breeds are returned and cached`() = runTest {
        assertEquals(emptyList(), sut.breeds.first())

        assertEquals(listOf(breed1, breed2), sut.get())

        assertEquals(listOf(breed1, breed2), sut.breeds.first())
    }
}