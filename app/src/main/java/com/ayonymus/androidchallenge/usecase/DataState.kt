package com.ayonymus.androidchallenge.usecase

import com.ayonymus.androidchallenge.domain.MockData

sealed class DataState {

    object Loading: DataState()
    data class Success(val data: MockData):  DataState()
    data class Failure(val error: Throwable? = null):  DataState()

}
