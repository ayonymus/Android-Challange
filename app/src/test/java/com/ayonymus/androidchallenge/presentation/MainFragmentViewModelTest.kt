package com.ayonymus.androidchallenge.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ayonymus.androidchallenge.presentation.rx.TestSchedulers
import com.ayonymus.androidchallenge.usecase.DataState
import com.ayonymus.androidchallenge.usecase.GetData
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class MainFragmentViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val getData = mock<GetData> {
        on { invoke() } doReturn Observable.just<DataState>(DataState.Loading)
    }

    private lateinit var viewModel: MainFragmentViewModel

    @Before
    fun setUp() {
        viewModel = MainFragmentViewModel(getData, TestSchedulers())
    }

    @Test
    fun `given live data when loadData called then return Loading`() {
        val liveData = viewModel.liveData()
        viewModel.loadData()
        assertEquals(DataState.Loading, liveData.value)
    }

    @Test
    fun `given data loaded when loadData called then return cached data and don't get more data`() {
        val liveData = viewModel.liveData()
        viewModel.loadData()
        viewModel.loadData()
        assertEquals(DataState.Loading, liveData.value)
        verify(getData, times(1)).invoke()
    }

    @Test
    fun `given data loaded when loadData called with refersh then get more data`() {
        val liveData = viewModel.liveData()
        viewModel.loadData()
        viewModel.loadData(true)
        assertEquals(DataState.Loading, liveData.value)
        verify(getData, times(2)).invoke()
    }

    @Test
    fun `given data failure when loadData called then get more data`() {
        val liveData = viewModel.liveData()
        val failure = DataState.Failure()
        whenever(getData.invoke()).doReturn(Observable.just<DataState>(failure))

        viewModel.loadData()
        assertEquals(failure, liveData.value)

        whenever(getData.invoke()).doReturn(Observable.just<DataState>(DataState.Loading))
        viewModel.loadData()
        assertEquals(DataState.Loading, liveData.value)

        verify(getData, times(2)).invoke()
    }


}
