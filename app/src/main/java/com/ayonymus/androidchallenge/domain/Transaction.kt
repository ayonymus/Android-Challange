package com.ayonymus.androidchallenge.domain

data class Transaction(val result: Int,
                       val time: Long,
                       val hash: String,
                       val fee: Int)
