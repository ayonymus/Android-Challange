package com.ayon.marvel.data.remote.api

import com.ayon.marvel.data.remote.model.ComicDataWrapper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/comics")
    fun getComics(): Observable<ComicDataWrapper>

    @GET("/v1/public/comics")
    fun search(@Query("titleStartsWith")
               title: String,
               @Query("startYear")
               startYear: Int,
               @Query("format")
               format: String = "comic"
    ): Observable<ComicDataWrapper>

}
