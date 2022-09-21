package com.challengecrypto

import com.challengecrypto.Fragments.HomeFragment
import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.Models.IndividualSymbol
import com.challengecrypto.Models.ResponseCoin
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import org.json.JSONObject
import java.util.*


class WSListener(homeFragment: HomeFragment) : WebSocketListener() {
    private val CLOSE_STATUS:Int = 1000
    private val hf = homeFragment
    private val gson = Gson()
    private val json = JsonObject()

    override fun onOpen(webSocket: WebSocket, response: Response) {
//        webSocket.send("ola")
//        println("onOpen: "+response)
//        webSocket.send(ByteString.decodeHex("abcd"))
//        webSocket.close(CLOSE_STATUS, "Socket Closed!!")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        var jsn = JSONObject(text)
        var price:String = ""
        var symbol = jsn.getString("s")
        price = jsn.getString("a")
        if (symbol == "BUSDUSDT"){
            price = jsn.getString("b")
        }
        var percentage = jsn.getString("P")
//        println("Coin: "+symbol+" "+price+"-"+percentage)

//        var data = gson.fromJson(text,IndividualSymbol::class.java)
        var coinCrypto = CoinCrypto(R.drawable.bitcoin_icon,symbol,"",price,percentage)
        hf.updateCoins(coinCrypto)
//        val gson = Gson()
//        var coin = gson.fromJson(text, ResponseCoin::class.java)
//        if (coin.s.equals("BTCUSDT")){
//            var coinCrypto = CoinCrypto(coin.s,"Bitcoin",coin.c,"+9")
//            hf.updateCoins(coinCrypto)
//        }
        println("Coin: "+ coinCrypto.symbol + coinCrypto.price )
//        println("Lista: "+text)
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        print("Receive Bytes : " + bytes.hex());
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(CLOSE_STATUS, null);
        print("Closing Socket : " + code + " / " + reason);
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosed(webSocket, code, reason)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        println("Error : " + t.toString()+response);
    }


}