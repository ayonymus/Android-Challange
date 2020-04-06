package com.ayon.core.rx

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class SchedulerProvider {

    open fun ui() = AndroidSchedulers.mainThread()
    open fun io() = Schedulers.io()
    open fun computation() = Schedulers.computation()

}
