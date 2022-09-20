package com.challengecrypto.Adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.R

class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivIcon = itemView.findViewById<ImageView>(R.id.iv_symbol)
    val tvSymbol = itemView.findViewById<TextView>(R.id.tv_symbol)
    val tvName = itemView.findViewById<TextView>(R.id.tv_name)
    val tvPrice = itemView.findViewById<TextView>(R.id.tv_price)
    val tvPercentage = itemView.findViewById<TextView>(R.id.tv_percentage)

    fun render (coin: CoinCrypto){
        tvSymbol.text = coin.symbol
        tvName.text = coin.name
        tvPrice.text = coin.price
        tvPercentage.text = coin.percentage
//        when(coin.symbol){
//            "BTCUSDT"->{
//                listCoins[0].price = coin.price
//            }
//            "ETHUSDT"->{
//                listCoins[1].price = coin.price
//                listCoins[1].percentage = coin.percentage
//            }
//            "BNBUSDT"->{
//                listCoins[2].price = coin.price
//                listCoins[2].percentage = coin.percentage
//            }
//            "LUNAUSDT"->{
//                listCoins[3].price = coin.price
//                listCoins[3].percentage = coin.percentage
//            }
//            "SOLUSDT"->{
//                listCoins[4].price = coin.price
//                listCoins[4].percentage = coin.percentage
//            }
//            "LTCUSDT"->{
//                listCoins[5].price = coin.price
//                listCoins[5].percentage = coin.percentage
//            }
//            "MATICUSDT"->{
//                listCoins[6].price = coin.price
//                listCoins[6].percentage = coin.percentage
//            }
//            "AVAXUSDT"->{
//                listCoins[7].price = coin.price
//                listCoins[7].percentage = coin.percentage
//            }
//            "XRPUSDT"->{
//                listCoins[8].price = coin.price
//                listCoins[8].percentage = coin.percentage
//            }
//            "BUSDUSDT"->{
//                listCoins[9].price = coin.price
//                listCoins[9].percentage = coin.percentage
//            }
    }





}