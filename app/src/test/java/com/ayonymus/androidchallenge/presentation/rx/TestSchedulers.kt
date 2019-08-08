package com.ayonymus.androidchallenge.presentation.rx

import io.reactivex.schedulers.Schedulers

class TestSchedulers: RxSchedulers {

    override fun io() = Schedulers.trampoline()
    override fun main() = Schedulers.trampoline()

}
