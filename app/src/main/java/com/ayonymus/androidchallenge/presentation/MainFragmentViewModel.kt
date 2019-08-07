package com.ayonymus.androidchallenge.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.ayonymus.androidchallenge.usecase.DataState
import com.ayonymus.androidchallenge.usecase.GetData
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * ViewModel to the MainFragment.
 *
 * There is no unit test for this class as it appears that would be framework testing.
 * Some integration testing could be written with Espresso without mocking this class out
 *
 */
class MainFragmentViewModel @Inject constructor(getData: GetData): ViewModel() {

    // LiveDataReactiveStreams bridges Rx and LiveData
    private val liveData = LiveDataReactiveStreams.fromPublisher(
        getData.invoke()
            .toFlowable(BackpressureStrategy.BUFFER)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()))

    fun getData(): LiveData<DataState> = liveData

}
