package com.challengecrypto.Adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.R

class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvSymbol = itemView.findViewById<TextView>(R.id.tv_symbol)
    val tvName = itemView.findViewById<TextView>(R.id.tv_name)
    val tvPrice = itemView.findViewById<TextView>(R.id.tv_price)
    val tvPercentage = itemView.findViewById<TextView>(R.id.tv_percentage)

    fun render (coin: CoinCrypto){
        tvSymbol.text = coin.symbol
        tvName.text = coin.name
        tvPrice.text = coin.price
        tvPercentage.text = coin.percentage
    }





}