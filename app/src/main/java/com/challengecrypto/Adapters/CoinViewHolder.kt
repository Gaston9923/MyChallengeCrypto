package com.challengecrypto.Adapters

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.R

class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var listCoin = mutableListOf<CoinCrypto>()
    var ivIcon = itemView.findViewById<ImageView>(R.id.iv_symbol)
    var tvSymbol = itemView.findViewById<TextView>(R.id.tv_symbol)
    var tvName = itemView.findViewById<TextView>(R.id.tv_name)
    var tvPrice = itemView.findViewById<TextView>(R.id.tv_price)
    var tvPercentage = itemView.findViewById<TextView>(R.id.tv_percentage)

    fun render (coin: CoinCrypto, listcoins: List<CoinCrypto>){
        listCoin = listcoins as MutableList<CoinCrypto>
        tvSymbol.text = coin.symbol
        tvName.text = coin.name
        tvPrice.text = coin.price
        tvPercentage.text = coin.percentage
        ivIcon.setImageResource(coin.icon)

//        setIconsCoin(coin)
        roundPercentageCoin(coin)
        }

    fun roundPercentageCoin(coin: CoinCrypto){
        if(coin.percentage != "" && coin.percentage.toDoubleOrNull()!=null){
            var per = coin.percentage.toDouble()
            var roundValue = String.format("%.2f",per)
            roundValue = roundValue.replace(".",",")
            if (per < 0.00){
                tvPercentage.setTextColor(Color.parseColor("#ffff4444"))
                tvPercentage.text = roundValue + "%"
            }else{
                tvPercentage.setTextColor(Color.parseColor("#66BB6A"))
                tvPercentage.text = "+"+roundValue + "%"
            }
        }
    }

    fun setIconsCoin(coin: CoinCrypto){
        when(coin.symbol){
            "BTC"->{
                ivIcon.setImageResource(R.drawable.bitcoin_icon)
            }
            "ETH"->{
                ivIcon.setImageResource(R.drawable.ethereum_icon)
            }
            "BNB"->{
                ivIcon.setImageResource(R.drawable.bnb_icon)
            }
            "LUNA"->{
                ivIcon.setImageResource(R.drawable.terra_luna_icon)
            }
            "SOL"->{
                ivIcon.setImageResource(R.drawable.solana_icon)
            }
            "LTC"->{
                ivIcon.setImageResource(R.drawable.litecoin_icon)
            }
            "MATIC"->{
                ivIcon.setImageResource(R.drawable.polygon_icon)
            }
            "AVAX"->{
                ivIcon.setImageResource(R.drawable.avalanche_avax_logo)
            }
            "XRP"->{
                ivIcon.setImageResource(R.drawable.xrp_icon)
            }
            "BUSD"->{
                ivIcon.setImageResource(R.drawable.busd_coin)
            }
        }
    }

}