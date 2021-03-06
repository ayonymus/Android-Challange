package com.ayon.repository

import com.ayon.repository.datasource.DataSource
import io.reactivex.Observable

/**
 * Simple generic repository pattern built with Rx that only takes one data source into consideration,
 * and caches that response into memory. Once data is committed to cache then only that cached
 * data will be returned.
 *
 * In order for the caching to work, this class must be a singleton in the current setup.
 *
 */
class InMemoryCachingRepository<T>(private val dataSource: DataSource<T>): Repository<T> {

    private var cache: T? = null

    override fun getData(refresh: Boolean): Observable<T> = if(cache == null || refresh) {
        dataSource.getData()
            .doOnNext { cache = it }
    } else {
        Observable.just(cache)
    }

}
