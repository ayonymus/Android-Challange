package com.ayonymus.androidchallenge.domain.repository

import io.reactivex.Single

interface Repository<T> {

    fun getData(): Single<T>

}
