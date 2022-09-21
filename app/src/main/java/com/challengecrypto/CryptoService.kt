package com.challengecrypto

import com.challengecrypto.Models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoService {

    @GET("exchangeInfo")
    fun getExchangeInfo(): Call<ExchangeInfo>
    @GET("ticker/price")
    fun getPriceSymbols(): Call<List<SymbolCrypto>>
    @GET("capital/config/getall")
    fun getCoinInfo(): Call<String>
    @GET("ticker")
    fun get24hrPriceStatistics(@Query("symbol")symbol: String): Call<Ticker>

}