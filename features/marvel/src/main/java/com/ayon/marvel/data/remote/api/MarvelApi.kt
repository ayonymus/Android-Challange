package com.ayon.marvel.data.remote.api

import com.ayon.marvel.data.remote.model.ComicDataWrapper
import io.reactivex.Observable
import retrofit2.http.GET

interface MarvelApi {

    @GET("/v1/public/comics")
    fun getComics(): Observable<ComicDataWrapper>
}
