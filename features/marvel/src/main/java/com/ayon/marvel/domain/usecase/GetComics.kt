package com.ayon.marvel.domain.usecase

import com.ayon.core.rx.SchedulerProvider
import com.ayon.marvel.domain.model.Comic
import com.ayon.marvel.domain.model.DataState
import com.ayon.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Use case for getting data from repository.
 */
class GetComics @Inject constructor(private val repository: Repository<List<Comic>>,
                                    private val schedulers: SchedulerProvider) {

    operator fun invoke(): Observable<DataState> {
        return repository.getData()
            .map<DataState> { DataState.Success(it) }
            .startWith(DataState.Loading)
            .onErrorReturn { DataState.Failure(it) }
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
    }
}
