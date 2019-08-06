package com.ayonymus.androidchallenge.framework

import io.reactivex.Single
import retrofit2.http.GET

interface BlockchainApi {

    @GET("/multiaddr?active=xpub6CfLQa8fLgtouvLxrb8EtvjbXfoC1yqzH6YbTJw4dP7srt523AhcMV8Uh4K3TWSHz9oDWmn9MuJogzdGU3ncxkBsAC9wFBLmFrWT9Ek81kQ")
    fun getDetails(): Single<BlockchainResponse>

}
