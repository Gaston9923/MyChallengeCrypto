package com.challengecrypto

import com.challengecrypto.Models.ExchangeInfo
import com.challengecrypto.Models.ResponsePrice
import com.challengecrypto.Models.SymbolCrypto
import retrofit2.Call
import retrofit2.http.GET

interface CryptoService {

    @GET("exchangeInfo")
    fun getExchangeInfo(): Call<ExchangeInfo>

    @GET("ticker/price")
    fun getPriceSymbols(): Call<List<SymbolCrypto>>

    @GET("capital/config/getall")
    fun getCoinInfo(): Call<String>


    @GET("ticker/24hr")
    fun get24hrPriceStatistics(): Call<List<ResponsePrice>>

}