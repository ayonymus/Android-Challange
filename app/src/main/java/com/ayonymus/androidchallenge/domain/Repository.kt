package com.ayonymus.androidchallenge.domain

import io.reactivex.Single

interface Repository<T> {

    fun getData(): Single<T>

}
