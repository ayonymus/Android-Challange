package com.ayon.marvel.domain.usecase

import com.ayon.marvel.domain.model.Comic
import com.ayon.marvel.domain.model.DataState
import com.ayon.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Use case for getting data from repository.
 * Notice, thread switching does not happen in the chain here for easier testing.
 */
class GetComics @Inject constructor(private val repository: Repository<List<Comic>>) {

    fun invoke(): Observable<DataState> {
        return repository.getData()
            .map<DataState> { DataState.Success(it) }
            .startWith(DataState.Loading)
            .onErrorReturn { DataState.Failure(it) }
    }
}
