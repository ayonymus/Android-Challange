package com.ayonymus.androidchallenge.di

import com.ayonymus.androidchallenge.data.DataSource
import com.ayonymus.androidchallenge.domain.BitcoinWallet
import com.ayonymus.androidchallenge.framework.BlockchainDataSource
import dagger.Binds
import dagger.Module


@Module
abstract class FrameworkModule {

    @Binds
    abstract fun provideBlockchainDataSource(source: BlockchainDataSource): DataSource<BitcoinWallet>

}
