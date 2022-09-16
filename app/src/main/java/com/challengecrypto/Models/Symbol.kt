package com.challengecrypto.Models

data class Symbol(
    val allowTrailingStop: Boolean,
    val baseAsset: String,
    val baseAssetPrecision: Int,
    val cancelReplaceAllowed: Boolean,
    val filters: List<Any>,
    val icebergAllowed: Boolean,
    val isMarginTradingAllowed: Boolean,
    val isSpotTradingAllowed: Boolean,
    val ocoAllowed: Boolean,
    val orderTypes: List<String>,
    val permissions: List<String>,
    val quoteAsset: String,
    val quoteAssetPrecision: Int,
    val quoteOrderQtyMarketAllowed: Boolean,
    val quotePrecision: Int,
    val status: String,
    val symbol: String
)