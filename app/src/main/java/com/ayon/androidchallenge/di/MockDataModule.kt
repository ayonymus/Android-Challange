package com.ayon.androidchallenge.di

import com.ayon.androidchallenge.domain.MockData
import com.ayon.repository.datasource.DataSource
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * This module provides bindings to repositories
 */
@Module
class MockDataModule {

    @Provides
    fun provideMockDataSource() = object :
        DataSource<MockData> {
        override fun getData(): Observable<MockData> = Observable.just(MockData(List(100) { "Item $it" }))
            .delay(1, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun provideCachingRepositoryForMockData(source: DataSource<MockData>): com.ayon.repository.Repository<MockData>
            = com.ayon.repository.InMemoryCachingRepository(source)

}
