package com.ayon.marvel.data.local

import com.ayon.marvel.domain.model.Comic
import com.ayon.repository.StorageState
import com.ayon.repository.datasource.StorageDataSource
import io.reactivex.Observable
import javax.inject.Inject

class LocalComicSource @Inject constructor(private val comicsDao: ComicsDao): StorageDataSource<List<Comic>> {

    override fun storeData(data: List<Comic>) = comicsDao.insertComics(
        data.map { ComicEntity.fromComic(it) })

    override fun getData(): Observable<StorageState<List<Comic>>> = comicsDao.getComics()
        .map { data ->
            if(data.isEmpty()) {
                StorageState.Empty<List<Comic>>()
            } else {
                StorageState.Data(data.map { it.toComic() } )
            }
        }

    override fun clear() = comicsDao.deleteAllComics()

}
