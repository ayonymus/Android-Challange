package com.ayon.repository

sealed class StorageState<T> {
    class Empty<T>: StorageState<T>()
    data class Data<T>(val data: T): StorageState<T>()
}