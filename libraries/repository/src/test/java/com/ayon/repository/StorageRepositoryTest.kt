package com.ayon.repository

import com.ayon.repository.datasource.DataSource
import com.ayon.repository.datasource.StorageDataSource
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Completable
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

class StorageRepositoryTest {

    private val localItem = "Some data"
    private val remoteItem = "Some remote data"

    private val state: StorageState<String> = StorageState.Data(localItem)

    private val storageSource = mock<StorageDataSource<String>> {
        on { getData() } doReturn Observable.just(state)
        on { storeData(any()) } doReturn Completable.complete()
        on { clear() } doReturn Completable.complete()
    }

    private val remoteSource = mock<DataSource<String>> {
        on { getData() } doReturn Observable.just(remoteItem)
    }

    private lateinit var repository: StorageRepository<String>

    @Before
    fun setUp() {
        repository = StorageRepository(storageSource, remoteSource)
    }

    @Test
    fun `given storage has data when getData called then return stored data`() {
        // when
        val testObservable = repository.getData().test()

        // then
        testObservable.assertValue(localItem)
        testObservable.assertComplete()
        testObservable.assertNoErrors()
    }

    @Test
    fun `given storage has no data when getData called then clear local data, store new data and return remote`() {
        given(storageSource.getData()).willReturn(Observable.just(StorageState.Empty()))

        // when
        val testObservable = repository.getData().test()

        // then
        testObservable.assertValue(remoteItem)
        testObservable.assertComplete()
        testObservable.assertNoErrors()
        verify(storageSource).storeData(remoteItem)
    }

    @Test
    fun `given storage has data when getData with refresh called then return remote data and store it`() {
        // when
        val testObservable = repository.getData(true).test()

        // then
        testObservable.assertValues(remoteItem)
        testObservable.assertComplete()
        testObservable.assertNoErrors()
        verify(storageSource).clear()
        verify(storageSource).storeData(remoteItem)
    }

    @Test
    fun `given storage has data when getData with refresh called and remote errors then propagate error`() {
        val exception = RuntimeException()
        given(remoteSource.getData()).willReturn(Observable.error(exception))

        // when
        val testObservable = repository.getData(true).test()

        // then )
        testObservable.assertError(exception)
        verifyNoMoreInteractions(storageSource)
    }


}