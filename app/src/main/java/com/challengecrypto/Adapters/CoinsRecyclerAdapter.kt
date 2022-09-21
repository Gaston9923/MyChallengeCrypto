package com.challengecrypto.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challengecrypto.Controllers.CoinsController
import com.challengecrypto.R

class CoinsRecyclerAdapter(coinsController: CoinsController): RecyclerView.Adapter<CoinViewHolder>() {

    var listCoins = coinsController.listCoins

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(layoutInflater.inflate(R.layout.crypto_container,parent,false))
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = listCoins[position]
        holder.render(coin, listCoins)
    }

    override fun getItemCount(): Int{
        return listCoins.size
    }


}