package com.ayon.marvel.data.remote

import com.ayon.marvel.data.remote.api.MarvelApi
import com.ayon.marvel.domain.model.Comic
import com.ayon.repository.datasource.DataSource
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

/**
 * Responsible for mapping the Api objects to the domain
 */
class ComicsApiDataSource @Inject constructor(private val api: MarvelApi): DataSource<List<Comic>> {

    override fun getData(): Observable<List<Comic>> =
        api.getComics()
            .map { comics ->
                Timber.v(comics.toString())
                comics.data.results.map { comic -> Comic(comic.title, comic.thumbnail.toString()) }
            }


}
