package com.ayonymus.androidchallenge.framework

import com.ayonymus.androidchallenge.domain.BitcoinWallet
import com.ayonymus.androidchallenge.domain.Transaction
import javax.inject.Inject

/**
 * This class is responsible for mapping the API response into
 * the simpler domain objects.
 */
class BitcoinWalletMapper @Inject constructor() {

    fun map(response: BlockchainResponse): BitcoinWallet {
        return BitcoinWallet(
            response.wallet.final_balance,
            response.txs.map { tx ->
                    Transaction(tx.result, tx.hash, tx.time, tx.fee)
            })
    }
}
