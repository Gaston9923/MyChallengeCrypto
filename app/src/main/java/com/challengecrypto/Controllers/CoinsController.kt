package com.challengecrypto.Controllers

import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.R

class CoinsController() {
    var listCoins = mutableListOf<CoinCrypto>(
        CoinCrypto(R.drawable.bitcoin_icon, "BTCUSDT", "Bitcoin", "", ""),
        CoinCrypto(R.drawable.ethereum_icon, "ETHUSDT", "Ethereum", "", ""),
        CoinCrypto(R.drawable.bnb_icon, "BNBUSDT", "Binance Coin", "", ""),
        CoinCrypto(R.drawable.terra_luna_icon, "LUNAUSDT", "Luna", "", ""),
        CoinCrypto(R.drawable.solana_icon, "SOLUSDT", "Solana", "", ""),
        CoinCrypto(R.drawable.litecoin_icon, "LTCUSDT", "Litecoin", "", ""),
        CoinCrypto(R.drawable.polygon_icon, "MATICUSDT", "Polygon", "", ""),
        CoinCrypto(R.drawable.avalanche_avax_logo, "AVAXUSDT", "Avalanche", "", ""),
        CoinCrypto(R.drawable.xrp_icon, "XRPUSDT", "Xrp", "", ""),
        CoinCrypto(R.drawable.busd_coin, "BUSDUSDT", "Binance USD", "", ""),
    )
    var listSymbolsUpdated =
        mutableListOf<Boolean>(false, false, false, false, false, false, false, false, false, false)
    var symbolsUpdated = false
    var characters = 4
    var count = 10
    private val CCL = 200



    fun updateSymbol(position: Int) {
        count = 0
        if (!listSymbolsUpdated[position]) {
            listCoins[position].symbol = removeLastNchars(listCoins[position].symbol, characters).toString()
            listSymbolsUpdated[position] = true
            for (i in 0..9) {
                if (listSymbolsUpdated[i]) {
                    count++
                }
            }
        }
        if (count == 10) {
            symbolsUpdated = true
        }
    }

    fun resumeSymbols(coin: CoinCrypto) {
        if (!symbolsUpdated) {
            when (coin.symbol) {
                "BTCBUSD" -> {
                    updateSymbol(0)
                }
                "ETHBUSD" -> {
                    updateSymbol(1)
                }
                "BNBBUSD" -> {
                    updateSymbol(2)
                }
                "LUNABUSD" -> {
                    updateSymbol(3)
                }
                "SOLBUSD" -> {
                    updateSymbol(4)
                }
                "LTCBUSD" -> {
                    updateSymbol(5)
                }
                "MATICBUSD" -> {
                    updateSymbol(6)
                }
                "AVAXBUSD" -> {
                    updateSymbol(7)
                }
                "XRPBUSD" -> {
                    updateSymbol(8)
                }
                "BUSDUSDT" -> {
                    updateSymbol(9)
                }
            }
        }
    }

    fun updateListCoin(coin: CoinCrypto, countryArg: Boolean) {
        resumeSymbols(coin)
        var price:Double = coin.price.toDouble()
        if (countryArg){
            if (coin.symbol != "BUSDUSDT"){
                price *= CCL
            }
            val roundOff = String.format("%.4f",price)
            coin.price = roundOff
        }else{
            if (coin.symbol == "BUSDUSDT"){
                price *= CCL
            }
            val roundOff = String.format("%.2f",price)
            coin.price = roundOff
        }

        when (coin.symbol) {
            "BTCBUSD" -> {
                listCoins[0].price = coin.price
                listCoins[0].percentage = coin.percentage
            }
            "ETHBUSD" -> {
                listCoins[1].price = coin.price
                listCoins[1].percentage = coin.percentage
            }
            "BNBBUSD" -> {
                listCoins[2].price = coin.price
                listCoins[2].percentage = coin.percentage
            }
            "LUNABUSD" -> {
                listCoins[3].price = coin.price
                listCoins[3].percentage = coin.percentage
            }
            "SOLBUSD" -> {
                listCoins[4].price = coin.price
                listCoins[4].percentage = coin.percentage
            }
            "LTCBUSD" -> {
                listCoins[5].price = coin.price
                listCoins[5].percentage = coin.percentage
            }
            "MATICBUSD" -> {
                listCoins[6].price = coin.price
                listCoins[6].percentage = coin.percentage
            }
            "AVAXBUSD" -> {
                listCoins[7].price = coin.price
                listCoins[7].percentage = coin.percentage
            }
            "XRPBUSD" -> {
                listCoins[8].price = coin.price
                listCoins[8].percentage = coin.percentage
            }
            "BUSDUSDT" -> {
                price = ((1 / coin.price.toDouble())*200)
                val roundOff = String.format("%.4f",price)
                coin.price = roundOff
                listCoins[9].price = coin.price
                listCoins[9].percentage = coin.percentage
            }

        }
    }

    fun removeLastNchars(str: String?, n: Int): String? {
        return if (str == null || str.length < n) {
            str
        } else str.substring(0, str.length - n)
    }

}