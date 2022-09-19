package com.challengecrypto.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.challengecrypto.CoinsController
import com.challengecrypto.CoinsCryptoInterface
import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.R

class CoinsRecyclerAdapter(coinsController: CoinsController): RecyclerView.Adapter<CoinViewHolder>() {

    var listCoins = coinsController.listCoins

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(layoutInflater.inflate(R.layout.crypto_container,parent,false))
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = listCoins[position]
        holder.render(coin)
    }

    override fun getItemCount(): Int{
        println("Cantidad:"+listCoins.size)
        return listCoins.size
    }

//    @SuppressLint("NotifyDataSetChanged")
//    override fun updateCoinCrypto(list: MutableList<CoinCrypto>) {
//        println("RvActualizado")
//        listCoins = list
//        this.notifyDataSetChanged()
//    }
}