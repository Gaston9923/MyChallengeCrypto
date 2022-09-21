package com.challengecrypto.Models

import com.challengecrypto.R

class CoinCrypto(icon: Int,symbol: String,name:String,price:String,percentage:String) {
    var icon:Int = icon
    var symbol: String = symbol
    var name: String = name
    var price: String = price
    var percentage: String = percentage

    constructor():this(R.drawable.bitcoin_icon,"","","",""){

    }




}