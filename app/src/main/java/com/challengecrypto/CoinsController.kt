package com.challengecrypto

import com.challengecrypto.Adapters.CoinsRecyclerAdapter
import com.challengecrypto.Fragments.HomeFragment
import com.challengecrypto.Models.CoinCrypto

class CoinsController(homeFragment: HomeFragment) {
    var listCoins = mutableListOf<CoinCrypto>()
//    var coinsCryptoInterface: CoinsCryptoInterface = homeFragment

    public fun getDataCoins():List<CoinCrypto>{
        return listCoins
    }


    fun updateListCoin(coin:CoinCrypto){
        if (listCoins.size == 0){
            listCoins.add(coin)
        }
        for (c in listCoins){
            if (c.symbol==coin.symbol){
                c.price = coin.price
//                coinsCryptoInterface.updateCoinCrypto(listCoins)
                println("Precio actualizado: "+c.price)
            }else{
                listCoins.add(coin)
                println("C:"+listCoins.size)
            }
        }
    }


}