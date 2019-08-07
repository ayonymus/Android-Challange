package com.ayonymus.androidchallenge.domain

/**
 *
 * Since the api is returning bitcoin values in Satoshis and there is a finite supply of bitcoins that fit into a
 * [Long], and there will not be arithmetic operations on them in this project, Satoshis can be represented as a long
 */
data class BitcoinWallet(
    val balance: Long,
    val data: List<Transaction>)
