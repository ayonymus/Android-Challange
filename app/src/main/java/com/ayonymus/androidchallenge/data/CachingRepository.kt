package com.ayonymus.androidchallenge.data

import com.ayonymus.androidchallenge.domain.repository.DataSource
import com.ayonymus.androidchallenge.domain.repository.Repository
import io.reactivex.Single

/**
 * Simple generic repository pattern built with Rx that only takes one data source into consideration,
 * and caches that response into memory.
 *
 * In order for the caching to work, this class must be a singleton in the current setup.
 */
class CachingRepository<T>(private val dataSource: DataSource<T>):
    Repository<T> {

    private var cache: T? = null

    override fun getData(refresh: Boolean): Single<T> = if(cache == null || refresh) {
        dataSource.getData()
            .doOnSuccess { cache = it }
    } else {
        Single.just(cache)
    }

}
