package com.ayon.repository

import io.reactivex.Observable

interface Repository<T> {

    fun getData(refresh: Boolean = false): Observable<T>

}
