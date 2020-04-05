package com.ayon.mockfeature.domain

sealed class DataState {

    object Loading: DataState()
    data class Success(val data: MockData):  DataState()
    data class Failure(val error: Throwable? = null):  DataState()

}
