package com.ayon.repository

import io.reactivex.Observable

interface DataSource<T> {

    fun getData(): Observable<T>

}
