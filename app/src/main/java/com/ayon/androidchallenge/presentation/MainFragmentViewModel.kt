package com.ayon.androidchallenge.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.ayon.androidchallenge.usecase.DataState
import com.ayon.androidchallenge.usecase.GetData
import io.reactivex.BackpressureStrategy
import javax.inject.Inject

/**
 * ViewModel to the MainFragment.
 *
 * There is no unit test for this class as it appears that would be framework testing.
 * Some integration testing could be written with Espresso without mocking this class out
 *
 */
class MainFragmentViewModel @Inject constructor(getData: GetData): ViewModel() {

    // LiveDataReactiveStreams bridges Rx and LiveData without the need of explicit thread switching
    private val liveData = LiveDataReactiveStreams.fromPublisher(
        getData.invoke().toFlowable(BackpressureStrategy.BUFFER))

    fun getData(): LiveData<DataState> = liveData

}
