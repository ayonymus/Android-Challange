package com.ayon.repository.datasource

import com.ayon.repository.StorageState
import io.reactivex.Completable
import io.reactivex.Observable

interface StorageDataSource<T> {
    fun getData(): Observable<StorageState<T>>
    fun storeData(data: T): Completable
    fun clear(): Completable
}