package com.ayonymus.androidchallenge.di

import com.ayonymus.androidchallenge.domain.repository.DataSource
import com.ayonymus.androidchallenge.domain.entity.BitcoinWallet
import com.ayonymus.androidchallenge.framework.BlockchainDataSource
import dagger.Binds
import dagger.Module


@Module
abstract class FrameworkModule {

    @Binds
    abstract fun provideBlockchainDataSource(source: BlockchainDataSource): DataSource<BitcoinWallet>

}
