package com.challengecrypto.Models

data class ExchangeInfo(
    val exchangeFilters: List<Any>,
    val rateLimits: List<RateLimit>,
    val serverTime: Long,
    val symbols: List<Symbol>,
    val timezone: String
)