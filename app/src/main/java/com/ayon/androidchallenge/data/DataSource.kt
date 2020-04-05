package com.ayon.androidchallenge.data

import io.reactivex.Observable

interface DataSource<T> {

    fun getData(): Observable<T>

}
