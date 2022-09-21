package com.challengecrypto

import com.challengecrypto.Fragments.HomeFragment
import com.challengecrypto.Models.CoinCrypto

class CoinsController(homeFragment: HomeFragment) {
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


    public fun getDataCoins(): List<CoinCrypto> {
        return listCoins
    }

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

    fun updateSymbols(coin: CoinCrypto) {
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
        updateSymbols(coin)
        var price:Double = coin.price.toDouble()
        if (countryArg){
            price *= CCL
            val roundOff = String.format("%.4f",price)
            coin.price = roundOff
        }

//        when(coin.symbol){
//            "BUSDUSDT" -> {
//                price = (( 1 / coin.price.toDouble() )*CCL)
//                val roundOff = String.format("%.4f",price)
//                price = roundOff.toDouble()
//            }
//            else -> {
//                price = (coin.price.toDouble())
//            }
//        }
        price = (coin.price.toDouble())
        when (coin.symbol) {
            "BTCBUSD" -> {
                listCoins[0].price = price.toString()
                listCoins[0].percentage = coin.percentage
            }
            "ETHBUSD" -> {
                listCoins[1].price = price.toString()
                listCoins[1].percentage = coin.percentage
            }
            "BNBBUSD" -> {
                listCoins[2].price = price.toString()
                listCoins[2].percentage = coin.percentage
            }
            "LUNABUSD" -> {
                listCoins[3].price = price.toString()
                listCoins[3].percentage = coin.percentage
            }
            "SOLBUSD" -> {
                listCoins[4].price = price.toString()
                listCoins[4].percentage = coin.percentage
            }
            "LTCBUSD" -> {
                listCoins[5].price = price.toString()
                listCoins[5].percentage = coin.percentage
            }
            "MATICBUSD" -> {
                listCoins[6].price = price.toString()
                listCoins[6].percentage = coin.percentage
            }
            "AVAXBUSD" -> {
                listCoins[7].price = price.toString()
                listCoins[7].percentage = coin.percentage
            }
            "XRPBUSD" -> {
                listCoins[8].price = price.toString()
                listCoins[8].percentage = coin.percentage
            }
            "BUSDUSDT" -> {
                listCoins[9].price = ((1 / coin.price.toDouble())*200).toString()
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