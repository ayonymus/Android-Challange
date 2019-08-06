package com.ayonymus.androidchallenge.di

import com.ayonymus.androidchallenge.data.CachingRepository
import com.ayonymus.androidchallenge.data.DataSource
import com.ayonymus.androidchallenge.domain.Wallet
import com.ayonymus.androidchallenge.domain.Repository
import com.ayonymus.androidchallenge.domain.Transaction
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
    fun provideMockDataSource() = object : DataSource<Wallet> {
        val transactions = listOf(
            Transaction(10, 10L, "10", 10),
            Transaction(20, 20L, "20", 20)
            )
        override fun getData(): Single<Wallet> = Single.just(Wallet(transactions))
            .delay(1, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun provideCachingRepositoryForMockData(source: DataSource<Wallet>): Repository<Wallet>
            = CachingRepository(source)

}
