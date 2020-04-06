package com.ayon.marvel.data.local

import com.ayon.marvel.domain.model.Comic
import com.ayon.repository.datasource.StorageDataSource
import io.reactivex.Observable

class LocalDataSource: StorageDataSource<List<Comic>> {

    override fun storeData(data: List<Comic>) {

    }

    override fun getData(): Observable<List<Comic>> = Observable.empty()

}