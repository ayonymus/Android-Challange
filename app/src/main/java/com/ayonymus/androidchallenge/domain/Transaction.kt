package com.ayonymus.androidchallenge.domain

data class Transaction(val value: Long,
                       val hash: String,
                       val time: Long,
                       val fee: Long)
