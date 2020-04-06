package com.ayon.marvel.data.remote

import com.ayon.marvel.domain.model.Comic
import com.ayon.repository.datasource.DataSource
import io.reactivex.Observable
import javax.inject.Inject

class ComicsApiDataSource @Inject constructor(): DataSource<List<Comic>> {

    override fun getData(): Observable<List<Comic>> = Observable.empty()


}
