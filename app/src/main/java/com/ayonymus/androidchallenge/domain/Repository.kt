package com.ayonymus.androidchallenge.domain

import io.reactivex.Observable

interface Repository<T> {

    fun getData(): Observable<T>

}
