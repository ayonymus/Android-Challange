package com.ayonymus.androidchallenge.domain

import java.math.BigDecimal

data class Wallet(
    val balance: BigDecimal,
    val data: List<Transaction>)
