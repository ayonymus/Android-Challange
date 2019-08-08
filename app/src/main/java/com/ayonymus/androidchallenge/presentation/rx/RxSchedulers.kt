package com.ayonymus.androidchallenge.presentation.rx

import io.reactivex.Scheduler

/**
 * Interface for easily passing schedulers for testing
 */
interface RxSchedulers {

    fun io(): Scheduler
    fun main(): Scheduler

}
