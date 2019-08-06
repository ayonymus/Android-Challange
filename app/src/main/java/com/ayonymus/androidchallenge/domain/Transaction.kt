package com.ayonymus.androidchallenge.domain

import java.math.BigDecimal

data class Transaction(val value: BigDecimal,
                       val direction: Direction,
                       val time: Long,
                       val fee: BigDecimal)

enum class Direction {
    IN, OUT
}
