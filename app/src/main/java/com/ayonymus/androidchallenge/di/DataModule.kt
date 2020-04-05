package com.ayonymus.androidchallenge.di

import com.ayonymus.androidchallenge.data.SingleSourceCachingRepository
import com.ayonymus.androidchallenge.data.DataSource
import com.ayonymus.androidchallenge.domain.MockData
import com.ayonymus.androidchallenge.domain.Repository
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * This module provides binding repositories
 */
@Module
class DataModule {

    @Provides
    fun provideMockDataSource() = object : DataSource<MockData> {
        override fun getData(): Observable<MockData> = Observable.just(MockData(List(100) { "Item $it" }))
            .delay(1, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun provideCachingRepositoryForMockData(source: DataSource<MockData>): Repository<MockData>
            = SingleSourceCachingRepository(source)

}
