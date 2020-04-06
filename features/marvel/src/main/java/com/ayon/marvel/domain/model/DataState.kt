package com.ayon.marvel.domain.model

sealed class DataState {

    object Loading: DataState()
    data class Success(val data: List<Comic>):  DataState()
    data class Failure(val error: Throwable? = null):  DataState()

}
