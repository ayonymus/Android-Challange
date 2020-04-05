package com.ayon.repository.datasource

import io.reactivex.Observable

/**
 * Interface to represent a certain data source, either network or local
 */
interface DataSource<T> {

    fun getData(): Observable<T>

}
