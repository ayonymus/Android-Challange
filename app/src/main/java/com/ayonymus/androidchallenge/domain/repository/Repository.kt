package com.ayonymus.androidchallenge.domain.repository

import io.reactivex.Single

interface Repository<T> {

    fun getData(refresh: Boolean = false): Single<T>

}
