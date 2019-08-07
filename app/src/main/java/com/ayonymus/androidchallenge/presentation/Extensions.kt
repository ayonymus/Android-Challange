package com.ayonymus.androidchallenge.presentation

fun Long.satoshiToBtc() = String.format("%.9f", (this.toDouble() / 100000000.0))
