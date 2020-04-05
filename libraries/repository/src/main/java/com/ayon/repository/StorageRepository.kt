package com.ayon.repository

import com.ayon.repository.datasource.DataSource
import com.ayon.repository.datasource.StorageDataSource
import io.reactivex.Observable

/**
 * Repository that checks 2 sources for data in the following order:
 *
 * 1. storage DataSource, e.g. local database
 * 2. remote DataSource, e.g. REST api call
 *
 * Data from remote source is then stored in storage, and is used later.
 */
class StorageRepository<T>(
    private val storage: StorageDataSource<T>,
    private val remote: DataSource<T>
) : Repository<T> {

    override fun getData(refresh: Boolean): Observable<T> {
        return storage.getData()
            .isEmpty()
            .flatMapObservable { isEmpty ->
                when {
                    isEmpty -> getRemoteDataAndStore()
                    !isEmpty && refresh ->
                        getRemoteDataAndStore()
                            .startWith(storage.getData())
                    else -> storage.getData()
                }
            }
    }

    private fun getRemoteDataAndStore() = remote.getData()
        .doOnNext { storage.storeData(it) }
}
