package com.ayon.mockfeature.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.ayon.mockfeature.domain.DataState
import com.ayon.mockfeature.domain.GetData
import io.reactivex.BackpressureStrategy
import javax.inject.Inject

/**
 * ViewModel to the MainFragment.
 *
 * There is no unit test for this class as it appears that would be framework testing.
 * Some integration testing could be written with Espresso without mocking this class out
 *
 */
class MockFragmentViewModel @Inject constructor(getData: GetData): ViewModel() {

    // LiveDataReactiveStreams bridges Rx and LiveData without the need of explicit thread switching
    private val liveData = LiveDataReactiveStreams.fromPublisher(
        getData.invoke().toFlowable(BackpressureStrategy.BUFFER))

    fun getData(): LiveData<DataState> = liveData

}
