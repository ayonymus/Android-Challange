package com.ayonymus.androidchallenge.usecase

import com.ayonymus.androidchallenge.domain.Wallet
import com.ayonymus.androidchallenge.domain.Repository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import java.io.IOException

internal class GetDataTest {

    private val data = mock<Wallet> { }

    private val repository = mock<Repository<Wallet>> {
        on { getData() } doReturn Single.just(data)
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
        whenever(repository.getData()).doReturn(Single.error(exception))

        val testObservable = getData.invoke().test()

        testObservable.assertValues(DataState.Loading, DataState.Failure(exception))
    }
}
