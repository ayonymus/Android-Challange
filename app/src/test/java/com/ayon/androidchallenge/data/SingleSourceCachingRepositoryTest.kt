package com.ayon.androidchallenge.data

import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

internal class SingleSourceCachingRepositoryTest {

    private val item = "some string"

    private val source = mock<DataSource<String>> {
        on { getData() } doReturn Observable.just(item)
    }

    private lateinit var repository: SingleSourceCachingRepository<String>

    @Before
    fun `set up`() {
        repository = SingleSourceCachingRepository(source)
    }

    @Test
    fun `given a data source with data when repository queried then return data from data source`() {

        val testSingle = repository.getData().test()

        testSingle.assertValue { it == item }
        testSingle.assertComplete()
    }

    @Test
    fun `given a data source with data when repository queried again then return data from cache`() {

        val testSingle = repository.getData().test()
        val testSingle2 = repository.getData().test()

        testSingle2.assertValue { it == item }
        verify(source, times(1)).getData()
    }

}
