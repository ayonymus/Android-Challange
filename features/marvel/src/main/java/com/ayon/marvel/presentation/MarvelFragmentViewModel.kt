package com.ayon.marvel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.ayon.marvel.domain.model.DataState
import com.ayon.marvel.domain.usecase.GetComics
import io.reactivex.BackpressureStrategy
import javax.inject.Inject

/**
 * ViewModel to the MainFragment.
 *
 * There is no unit test for this class as it appears that would be framework testing.
 * Some integration testing could be written with Espresso without mocking this class out
 *
 */
class MarvelFragmentViewModel @Inject constructor(getComics: GetComics): ViewModel() {

    private val liveData = LiveDataReactiveStreams.fromPublisher(
        getComics().toFlowable(BackpressureStrategy.BUFFER))

    fun getData(): LiveData<DataState> = liveData

}
