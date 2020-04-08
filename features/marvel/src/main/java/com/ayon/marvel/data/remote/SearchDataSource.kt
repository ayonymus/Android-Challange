package com.ayon.marvel.data.remote

import com.ayon.marvel.data.remote.api.MarvelApi
import com.ayon.marvel.domain.model.Comic
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class SearchDataSource  @Inject constructor(private val api: MarvelApi) {

    fun getData(title: String = "", startYear: Int = 0): Observable<List<Comic>> =
        api.search(title, startYear)
            .map { comics ->
                Timber.v(comics.toString())
                comics.data.results.map { comic -> Comic(comic.title, comic.description,
                    comic.thumbnail.toString()) }
            }


}
