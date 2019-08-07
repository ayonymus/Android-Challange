package com.ayonymus.androidchallenge.domain.repository

import io.reactivex.Single

interface DataSource<T> {

    fun getData(): Single<T>

}
