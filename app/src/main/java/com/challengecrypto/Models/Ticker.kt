package com.challengecrypto.Models

data class Ticker(
    val closeTime: Long,
    val count: Int,
    val firstId: Int,
    val highPrice: String,
    val lastId: Int,
    val lastPrice: String,
    val lowPrice: String,
    val openPrice: String,
    val openTime: Long,
    val priceChange: String,
    val priceChangePercent: String,
    val quoteVolume: String,
    val symbol: String,
    val volume: String,
    val weightedAvgPrice: String
)