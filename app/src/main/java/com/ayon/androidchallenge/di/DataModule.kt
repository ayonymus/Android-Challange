package com.ayon.androidchallenge.di

import com.ayon.androidchallenge.data.SingleSourceCachingRepository
import com.ayon.androidchallenge.data.DataSource
import com.ayon.androidchallenge.domain.MockData
import com.ayon.androidchallenge.domain.Repository
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
