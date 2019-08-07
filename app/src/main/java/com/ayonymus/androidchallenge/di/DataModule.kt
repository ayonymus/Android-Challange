package com.ayonymus.androidchallenge.di

import com.ayonymus.androidchallenge.data.CachingRepository
import com.ayonymus.androidchallenge.data.DataSource
import com.ayonymus.androidchallenge.domain.BitcoinWallet
import com.ayonymus.androidchallenge.domain.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This module provides binding repositories
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideCachingRepositoryForMockData(source: DataSource<BitcoinWallet>): Repository<BitcoinWallet>
            = CachingRepository(source)

}
