package com.ayonymus.androidchallenge.framework

import com.ayonymus.androidchallenge.domain.BitcoinWallet
import com.ayonymus.androidchallenge.domain.Transaction
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.assertEquals
import org.junit.Test

internal class BitcoinWalletMapperTest {

    private val balance = 100L
    private val result = 20L
    private val hash = "asdfasdf"
    private val time = 1000L
    private val fee = 100L

    private val mockWallet = mock<Wallet> {
        on { final_balance } doReturn balance
    }
    private val mockTransaction = mock<Tx> {
        on { result } doReturn result
        on { hash } doReturn hash
        on { time } doReturn time
        on { fee } doReturn fee
    }
    private val response = mock<BlockchainResponse> {
        on { wallet } doReturn mockWallet
        on { txs } doReturn listOf(mockTransaction)
    }

    private val mapper = BitcoinWalletMapper()

    @Test
    fun `given an api response with no transactions then return expected BitcoinWallet`() {
        given { response.txs }.willReturn(emptyList())

        val expected = BitcoinWallet(balance, emptyList())

        val result = mapper.map(response)
        assertEquals(expected, result)
    }

    @Test
    fun `given an api response with transactions then return expected BitcoinWallet`() {
        val expected = BitcoinWallet(balance, listOf(Transaction(result, hash, time, fee)))

        val result = mapper.map(response)
        assertEquals(expected, result)
    }


}
