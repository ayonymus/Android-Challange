package com.ayonymus.androidchallenge.usecase

import com.ayonymus.androidchallenge.domain.MockData
import com.ayonymus.androidchallenge.domain.Repository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Use case for getting data from repository.
 * Notice, thread switching does not happen in the chain here for easier testing.
 */
class GetData @Inject constructor(private val repository: Repository<MockData>) {

    fun invoke(): Observable<DataState> {
        return repository.getData()
            .map<DataState> { DataState.Success(it) }
            .startWith(DataState.Loading)
            .onErrorReturn { DataState.Failure(it) }
    }
}
