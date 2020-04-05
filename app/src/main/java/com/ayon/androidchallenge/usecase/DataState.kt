package com.ayon.androidchallenge.usecase

import com.ayon.androidchallenge.domain.MockData

sealed class DataState {

    object Loading: DataState()
    data class Success(val data: MockData):  DataState()
    data class Failure(val error: Throwable? = null):  DataState()

}
