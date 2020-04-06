package com.ayon.marvel.di

import com.ayon.marvel.data.remote.ComicsApiDataSource
import com.ayon.marvel.data.remote.api.MarvelApi
import com.ayon.marvel.domain.model.Comic
import com.ayon.repository.InMemoryCachingRepository
import com.ayon.repository.Repository
import com.ayon.repository.datasource.DataSource
import dagger.Module
import dagger.Provides

@Module
class MarvelDataModule {

    @Provides
    fun provideComicsDataSource(comicsApi: MarvelApi): DataSource<List<Comic>> {
        return ComicsApiDataSource(comicsApi)
    }

    @Provides
    fun provideStorageRepository(comicsApiDataSource: ComicsApiDataSource):
            Repository<List<Comic>> {
        return InMemoryCachingRepository(comicsApiDataSource)
    }

}
