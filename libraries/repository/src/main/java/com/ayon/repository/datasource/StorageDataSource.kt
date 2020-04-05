package com.ayon.repository.datasource

interface StorageDataSource<T>: DataSource<T> {
    fun storeData(data: T)
}