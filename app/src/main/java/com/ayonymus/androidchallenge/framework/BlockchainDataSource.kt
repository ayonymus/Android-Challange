package com.ayonymus.androidchallenge.framework

import com.ayonymus.androidchallenge.data.DataSource
import com.ayonymus.androidchallenge.domain.BitcoinWallet
import io.reactivex.Single
import javax.inject.Inject

class BlockchainDataSource @Inject constructor(
    private val api: BlockchainApi,
    private val mapper: BitcoinWalletMapper
): DataSource<BitcoinWallet> {

    override fun getData(): Single<BitcoinWallet> {
        return api.getDetails()
            .map(mapper::map)
    }
}
