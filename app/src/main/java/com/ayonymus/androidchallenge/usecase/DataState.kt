package com.ayonymus.androidchallenge.usecase

import com.ayonymus.androidchallenge.domain.BitcoinWallet

sealed class DataState {

    object Loading: DataState()
    data class Success(val data: BitcoinWallet):  DataState()
    data class Failure(val error: Throwable? = null):  DataState()

}
