package com.ayon.androidchallenge.di

import android.content.Context
import androidx.room.Room
import com.ayon.marvel.data.local.ComicsDatabase
import com.ayon.marvel.data.local.ComicsDao
import com.ayon.marvel.data.local.LocalComicSource
import com.ayon.marvel.data.remote.ComicsApiDataSource
import com.ayon.marvel.data.remote.api.MarvelApi
import com.ayon.marvel.domain.model.Comic
import com.ayon.repository.Repository
import com.ayon.repository.StorageRepository
import com.ayon.repository.datasource.DataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MarvelDatabaseModule {

    @Provides
    @Singleton
    fun provideComicsDataSource(comicsApi: MarvelApi): DataSource<List<Comic>> {
        return ComicsApiDataSource(comicsApi)
    }

    @Provides
    @Singleton
    fun provideStorageRepository(comicsApiDataSource: ComicsApiDataSource,
                                 comicsLocalDataSource: LocalComicSource
    ):
            Repository<List<Comic>> {
        return StorageRepository(comicsLocalDataSource, comicsApiDataSource)
    }

    @Provides
    @Singleton
    fun provideComicsDatabase(context: Context): ComicsDatabase =
        Room.databaseBuilder(context.applicationContext, ComicsDatabase::class.java, "Comics.db")
            .build()

    @Provides
    @Singleton
    fun provideComicsDao(database: ComicsDatabase): ComicsDao = database.comicsDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(dao: ComicsDao): LocalComicSource =
        LocalComicSource(dao)
}
