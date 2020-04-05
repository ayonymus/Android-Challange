package com.ayon.androidchallenge.usecase

import com.ayon.androidchallenge.domain.MockData
import com.ayon.repository.Repository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import java.io.IOException

internal class GetDataTest {

    private val data = MockData(listOf("lol", "lel"))

    private val repository = mock<com.ayon.repository.Repository<MockData>> {
        on { getData() } doReturn Observable.just(data)
    }

    private lateinit var getData: GetData

    @Before
    fun setUp() {
        getData = GetData(repository)
    }

    @Test
    fun `given repository data when invoked then return observable with loading and data`() {
        val testObservable = getData.invoke().test()

        testObservable.assertComplete()
        testObservable.assertValues(DataState.Loading, DataState.Success(data))
    }


    @Test
    fun `given repository data with error when invoked then return with failure`() {
        val exception = IOException()
        whenever(repository.getData()).doReturn(Observable.error(exception))

        val testObservable = getData.invoke().test()

        testObservable.assertValues(DataState.Loading, DataState.Failure(exception))
    }
}
