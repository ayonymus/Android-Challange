package com.ayonymus.androidchallenge.usecase

import com.ayonymus.androidchallenge.domain.entity.BitcoinWallet
import com.ayonymus.androidchallenge.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Use case for getting data from repository.
 * Notice, thread switching does not happen in the chain here for easier testing.
 */
class GetData @Inject constructor(private val repository: Repository<BitcoinWallet>) {

    fun invoke(refresh: Boolean = false): Observable<DataState> {
        return repository.getData(refresh)
            .toObservable()
            .map<DataState> { DataState.Success(it) }
            .startWith(DataState.Loading)
            .onErrorReturn { DataState.Failure(it) }
    }
}
