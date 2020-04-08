package com.ayon.marvel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayon.marvel.domain.model.DataState
import com.ayon.marvel.domain.usecase.SearchComicUsecase
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val searchComicUsecase: SearchComicUsecase): ViewModel() {

    private val compositeSubscription = CompositeDisposable()

    private val mutableLiveDataState = MutableLiveData<DataState>()

    fun observeLiveData(): LiveData<DataState> = mutableLiveDataState

    fun queryComics(title: String, year: Int) {
        compositeSubscription.add(
            searchComicUsecase.search(title, year)
                .throttleFirst(1000, TimeUnit.SECONDS)
            .subscribe())
    }

    override fun onCleared() {
        compositeSubscription.clear()
        super.onCleared()
    }
}
