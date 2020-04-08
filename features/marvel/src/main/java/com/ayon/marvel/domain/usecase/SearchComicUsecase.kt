package com.ayon.marvel.domain.usecase

import com.ayon.core.rx.SchedulerProvider
import com.ayon.marvel.data.remote.SearchDataSource
import com.ayon.marvel.domain.model.DataState
import io.reactivex.Observable
import javax.inject.Inject

class SearchComicUsecase @Inject constructor(private val dataSource: SearchDataSource,
                                             private val schedulerProvider: SchedulerProvider) {

    fun search(title: String = "", startYear: Int = 0): Observable<DataState> =
        dataSource.getData(title, startYear)
            .subscribeOn(schedulerProvider.io())
            .map { DataState.Success(it) as DataState}
            .observeOn(schedulerProvider.ui())
            .startWith(DataState.Loading)
            .onErrorReturn { DataState.Failure(it) }


}
