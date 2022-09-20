package com.challengecrypto

import com.challengecrypto.Fragments.HomeFragment
import com.challengecrypto.Models.CoinCrypto

class CoinsController(homeFragment: HomeFragment) {
    var listCoins = mutableListOf<CoinCrypto>(
        CoinCrypto("BTCUSDT","Bitcoin","",""),
        CoinCrypto("ETHUSDT","Ethereum","",""),
        CoinCrypto("BNBUSDT","Binance Coin","",""),
        CoinCrypto("LUNAUSDT","Luna","",""),
        CoinCrypto("SOLUSDT","Solana","",""),
        CoinCrypto("LTCUSDT","Litecoin","",""),
        CoinCrypto("MATICUSDT","Polygon","",""),
        CoinCrypto("AVAXUSDT","Avalanche","",""),
        CoinCrypto("XRPUSDT","Xrp","",""),
        CoinCrypto("BUSDUSDT","Binance USD","",""),
    )
//    var listCoins = mutableListOf<CoinCrypto>(
//        CoinCrypto("","Bitcoin","","+9"),
//        CoinCrypto("","Bitcoin","","+9"),
//        CoinCrypto("","Bitcoin","","+9"),
//        CoinCrypto("","Bitcoin","","+9"),
//        CoinCrypto("","Bitcoin","","+9"),
//        CoinCrypto("","Bitcoin","","+9"),
//        CoinCrypto("","Bitcoin","","+9"),
//        CoinCrypto("","Bitcoin","","+9"),
//        CoinCrypto("","Bitcoin","","+9"),
//        CoinCrypto("","Bitcoin","","+9")
//    )


    public fun getDataCoins():List<CoinCrypto>{
        return listCoins
    }


    fun updateListCoin(coin:CoinCrypto){
        when(coin.symbol){
            "BTCUSDT"->{
                listCoins[0].price = coin.price
                listCoins[0].percentage = coin.percentage
            }
            "ETHUSDT"->{
                listCoins[1].price = coin.price
                listCoins[1].percentage = coin.percentage
            }
            "BNBUSDT"->{
                listCoins[2].price = coin.price
                listCoins[2].percentage = coin.percentage
            }
            "LUNAUSDT"->{
                listCoins[3].price = coin.price
                listCoins[3].percentage = coin.percentage
            }
            "SOLUSDT"->{
                listCoins[4].price = coin.price
                listCoins[4].percentage = coin.percentage
            }
            "LTCUSDT"->{
                listCoins[5].price = coin.price
                listCoins[5].percentage = coin.percentage
            }
            "MATICUSDT"->{
                listCoins[6].price = coin.price
                listCoins[6].percentage = coin.percentage
            }
            "AVAXUSDT"->{
                listCoins[7].price = coin.price
                listCoins[7].percentage = coin.percentage
            }
            "XRPUSDT"->{
                listCoins[8].price = coin.price
                listCoins[8].percentage = coin.percentage
            }
            "BUSDUSDT"->{
                listCoins[9].price = coin.price
                listCoins[9].percentage = coin.percentage
            }

        }
    }

//    fun updateListCoin(coin:CoinCrypto){
////        for(c in listCoins){
////            if (coin.symbol = c.symbol){
////
////            }
////        }
//        if(listCoins.size == 0){
//            listCoins.add(coin)
//        }
//        for (c in listCoins){
//            if (c.symbol==coin.symbol){
//                c.price = coin.price
////                coinsCryptoInterface.updateCoinCrypto(listCoins)
//                println("Precio actualizado: "+c.price)
//            }
//        }
//    }


}