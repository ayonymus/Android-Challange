package com.ayon.repository

import io.reactivex.Observable

interface Repository<T> {

    fun getData(): Observable<T>

}
