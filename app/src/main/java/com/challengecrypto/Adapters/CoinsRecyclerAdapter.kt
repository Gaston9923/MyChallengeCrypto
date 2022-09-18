package com.challengecrypto.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.R

class CoinsRecyclerAdapter(val coinsList:List<CoinCrypto>): RecyclerView.Adapter<CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(layoutInflater.inflate(R.layout.crypto_container,parent,false))
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinsList[position]
        holder.render(coin)
    }

    override fun getItemCount(): Int{
        println("Cantidad:"+coinsList.size)
        return coinsList.size
    }
}