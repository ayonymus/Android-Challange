package com.ayon.marvel.domain.usecase

import com.ayon.marvel.domain.model.Comic
import com.ayon.marvel.domain.model.DataState
import com.ayon.repository.Repository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import java.io.IOException

class GetComicsTest {

    private val data = listOf(Comic("lol"), Comic("lel"))

    private val repository = mock<Repository<List<Comic>>> {
        on { getData() } doReturn Observable.just(data)
    }

    private lateinit var getComics: GetComics

    @Before
    fun setUp() {
        getComics = GetComics(repository)
    }

    @Test
    fun `given repository data when invoked then return observable with loading and data`() {
        val testObservable = getComics.invoke().test()

        testObservable.assertComplete()
        testObservable.assertValues(DataState.Loading, DataState.Success(data))
    }


    @Test
    fun `given repository data with error when invoked then return with failure`() {
        val exception = IOException()
        whenever(repository.getData()).doReturn(Observable.error(exception))

        val testObservable = getComics.invoke().test()

        testObservable.assertValues(DataState.Loading, DataState.Failure(exception))
    }

}