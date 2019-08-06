package com.ayonymus.androidchallenge.di

import com.ayonymus.androidchallenge.data.CachingRepository
import com.ayonymus.androidchallenge.data.DataSource
import com.ayonymus.androidchallenge.domain.Direction
import com.ayonymus.androidchallenge.domain.Wallet
import com.ayonymus.androidchallenge.domain.Repository
import com.ayonymus.androidchallenge.domain.Transaction
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import java.math.BigDecimal
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
            Transaction(BigDecimal.valueOf(10), Direction.IN, 10, BigDecimal.valueOf(10)),
            Transaction(BigDecimal.valueOf(20), Direction.IN, 20, BigDecimal.valueOf(10)),
            Transaction(BigDecimal.valueOf(30), Direction.OUT, 30, BigDecimal.valueOf(10)))
        override fun getData(): Single<Wallet> = Single.just(Wallet(BigDecimal.ZERO, transactions))
            .delay(1, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun provideCachingRepositoryForMockData(source: DataSource<Wallet>): Repository<Wallet>
            = CachingRepository(source)

}
