package com.challengecrypto.Adapters

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
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

        setIconsCoin(coin)
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
                ivIcon.getBackground().setColorFilter(Color.parseColor("#FFCCBC"), PorterDuff.Mode.SRC_ATOP)
            }
            "ETH"->{
                ivIcon.getBackground().setColorFilter(Color.parseColor("#D1C4E9"), PorterDuff.Mode.SRC_ATOP)
            }
            "BNB"->{
                ivIcon.getBackground().setColorFilter(Color.parseColor("#F0F4C3"), PorterDuff.Mode.SRC_ATOP)
            }
            "LUNA"->{
                ivIcon.getBackground().setColorFilter(Color.parseColor("#BBDEFB"), PorterDuff.Mode.SRC_ATOP)
            }
            "SOL"->{
                ivIcon.getBackground().setColorFilter(Color.parseColor("#D1C4E9"), PorterDuff.Mode.SRC_ATOP)
            }
            "LTC"->{
                ivIcon.getBackground().setColorFilter(Color.parseColor("#CFCFCF"), PorterDuff.Mode.SRC_ATOP)
            }
            "MATIC"->{
                ivIcon.getBackground().setColorFilter(Color.parseColor("#D1C4E9"), PorterDuff.Mode.SRC_ATOP)
            }
            "AVAX"->{
                ivIcon.getBackground().setColorFilter(Color.parseColor("#F8BBC0"), PorterDuff.Mode.SRC_ATOP)
            }
            "XRP"->{
                ivIcon.getBackground().setColorFilter(Color.parseColor("#CFCFCF"), PorterDuff.Mode.SRC_ATOP)
            }
            "BUSD"->{
                ivIcon.getBackground().setColorFilter(Color.parseColor("#F0F4C3"), PorterDuff.Mode.SRC_ATOP)
            }
        }
    }

}