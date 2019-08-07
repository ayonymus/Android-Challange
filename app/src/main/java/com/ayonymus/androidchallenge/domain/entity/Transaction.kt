package com.ayonymus.androidchallenge.domain.entity

data class Transaction(val value: Long,
                       val hash: String,
                       val time: Long,
                       val fee: Long)
