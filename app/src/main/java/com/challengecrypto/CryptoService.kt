package com.challengecrypto

import com.challengecrypto.Models.ExchangeInfo
import com.challengecrypto.Models.SymbolCrypto
import retrofit2.Call
import retrofit2.http.GET

interface CryptoService {

    @GET("exchangeInfo")
    fun getExchangeInfo(): Call<ExchangeInfo>

    @GET("ticker/price")
    fun getPriceSymbols(): Call<List<SymbolCrypto>>

}