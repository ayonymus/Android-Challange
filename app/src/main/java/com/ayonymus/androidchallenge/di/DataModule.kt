package com.ayonymus.androidchallenge.di

import com.ayonymus.androidchallenge.data.CachingRepository
import com.ayonymus.androidchallenge.data.DataSource
import com.ayonymus.androidchallenge.domain.MockData
import com.ayonymus.androidchallenge.domain.Repository
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * This module provides binding repositories
 */
@Module
class DataModule {

    @Provides
    fun provideMockDataSource() = object : DataSource<MockData> {
        override fun getData(): Single<MockData> = Single.just(MockData(List(100) { "Item $it" }))
            .delay(1, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun provideCachingRepositoryForMockData(source: DataSource<MockData>): Repository<MockData>
            = CachingRepository(source)

}
