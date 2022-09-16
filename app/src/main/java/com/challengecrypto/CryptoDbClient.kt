package com.challengecrypto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object CryptoDbClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.binance.com/api/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(CryptoService::class.java)

}