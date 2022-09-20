package com.challengecrypto

import com.challengecrypto.Fragments.HomeFragment
import com.challengecrypto.Models.CoinCrypto

class CoinsController(homeFragment: HomeFragment) {
    var listCoins = mutableListOf<CoinCrypto>()
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

//        for(c in listCoins){
//            if (coin.symbol = c.symbol){
//
//            }
//        }
        if(listCoins.size == 0){
         listCoins.add(coin)
        }
        for (c in listCoins){
            if (c.symbol==coin.symbol){
                c.price = coin.price
//                coinsCryptoInterface.updateCoinCrypto(listCoins)
                println("Precio actualizado: "+c.price)
            }
        }
    }


}