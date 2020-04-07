package com.ayon.repository

import com.ayon.repository.datasource.DataSource
import com.ayon.repository.datasource.StorageDataSource
import io.reactivex.Observable
import timber.log.Timber

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
        return if(refresh) {
            Timber.v("Refreshing data")
            getRemoteDataAndStore()
        }
        else {
            storage.getData()
                .flatMap { result ->
                    when (result) {
                        is StorageState.Empty<T> -> getRemoteDataAndStore()
                        is StorageState.Data<T> -> {
                            Timber.v("Local data")
                            Observable.just(result.data)
                        }
                    }
                }

        }
    }

    private fun getRemoteDataAndStore() = remote.getData()
        .flatMap {
            storage.clear()
                .andThen(storage.storeData(it))
                .andThen(Observable.just(it)) }
}
