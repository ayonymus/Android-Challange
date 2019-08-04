package com.ayonymus.androidchallenge.data

import io.reactivex.Single

interface DataSource<T> {

    fun getData(): Single<T>

}
