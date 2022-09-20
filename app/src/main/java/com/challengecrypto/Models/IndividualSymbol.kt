package com.challengecrypto.Models

data class IndividualSymbol(
    val bestAskQuantity: String,
    val bestBidQuantity: String,
    val statisticsCloseTime: Int,
    val eventTime: Int,
    val firstTradeID: Int,
    val lastTradeId: Int,
    val statisticsOpenTime: Int,
    val priceChangePercent: String,
    val lastQuantity: String,
    val bestAskPrice: String,
    val bestBidPrice: String,
    val lastPrice: String,
    val eventType: String,
    val highPrice: String,
    val lowPrice: String,
    val totalNumberOfTrades: Int,
    val openPrice: String,
    val priceChange: String,
    val totalTradedQuoteAssetVolume: String,
    val symbol: String,
    val totalTradedBaseAssetVolume: String,
    val weightedAveragePrice: String,
    val firstTrade: String
)