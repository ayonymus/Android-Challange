package com.ayonymus.androidchallenge.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayonymus.androidchallenge.presentation.rx.RxSchedulers
import com.ayonymus.androidchallenge.usecase.DataState
import com.ayonymus.androidchallenge.usecase.GetData
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

/**
 * ViewModel to the MainFragment.
 */
class MainFragmentViewModel @Inject constructor(private val getData: GetData,
                                                private val schedulers: RxSchedulers
): ViewModel() {

    private val disposables = CompositeDisposable()
    private val liveData = MutableLiveData<DataState>()

    fun liveData(): LiveData<DataState> = liveData

    fun loadData(reload: Boolean = false) {
        val data = liveData.value
        if(data == null || data is DataState.Failure || reload) {
            disposables.add(getData.invoke()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.main())
                .subscribe( { state ->
                    Timber.v(state.toString())
                    liveData.setValue(state)
                },
                    { error ->
                        Timber.e(error)
                        liveData.postValue(DataState.Failure(error))
                    }
                ))
        }
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

}
