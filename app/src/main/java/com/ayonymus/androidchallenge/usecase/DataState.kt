package com.ayonymus.androidchallenge.usecase

import com.ayonymus.androidchallenge.domain.Wallet

sealed class DataState {

    object Loading: DataState()
    data class Success(val data: Wallet):  DataState()
    data class Failure(val error: Throwable? = null):  DataState()

}
