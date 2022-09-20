package com.challengecrypto.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.challengecrypto.Adapters.CoinsRecyclerAdapter
import com.challengecrypto.CoinsController
import com.challengecrypto.CryptoDbClient
import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.Models.Ticker
import com.challengecrypto.R
import com.challengecrypto.WSListener
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment() : Fragment() {
    private val coinsController = CoinsController(this)
    private val coinRecyclerAdapter = CoinsRecyclerAdapter(coinsController)
    private var countryArg = true
    private val CCL = 200
    private var priceChangePercentage:String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val context:Context = this.requireContext()
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        val spinner:Spinner = view.findViewById(R.id.sp_cotizacion)
        val rvCoins: RecyclerView = view.findViewById(R.id.rv_coins)
//        getResponse24Statistics()

        rvCoins.layoutManager = GridLayoutManager(this.requireContext(),1)
        rvCoins.setHasFixedSize(true)
        rvCoins.adapter = coinRecyclerAdapter


        ArrayAdapter.createFromResource(context,R.array.cotizaciones,android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                val selectedItem = parent!!.getItemAtPosition(position).toString()
                countryArg = if(position == 0 ) true else false
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        startWebSocket()
        return view
    }

    private fun getResponse24Statistics(){
        CryptoDbClient.service.get24hrPriceStatistics("BTCUSDT").enqueue(object : Callback<Ticker> {
            override fun onResponse(call: Call<Ticker>, response: Response<Ticker>) {
                println(":: "+response.body().toString())
                var gson = Gson()
                var ticker: Ticker? = response.body()
                priceChangePercentage = ticker?.priceChangePercent.toString()
                println(priceChangePercentage)
            }

            override fun onFailure(call: Call<Ticker>, t: Throwable) {
                println("Error: $t")
            }

        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun startWebSocket(){
        val client = OkHttpClient().newBuilder().writeTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS).readTimeout(40, TimeUnit.SECONDS).build()
//        val serverUrl:String = "wss://stream.binance.com:9443/ws/btcusdt@trade"
          val serverUrl:String = "wss://stream.binance.com:9443/ws/btcusdt@ticker/bnbusdt@ticker/ethusdt@ticker/lunausdt@ticker/solusdt@ticker/ltcusdt@ticker/maticusdt@ticker/avaxusdt@ticker/xrpusdt@ticker/busdusdt@ticker"

//        val serverUrl:String = "wss://stream.binance.com:9443/ws/!miniTicker@arr"
//        val serverUrl:String = "wss://stream.binance.com:9443/ws/btcusdt@miniTicker/" +
//                                                                "bnbbusd@miniTicker/" +
//                                                                "ethbusd@miniTicker/" +
//                                                                "lunabusd@miniTicker/" +
//                                                                "solbusd@miniTicker/" +
//                                                                "ltcbusd@miniTicker/" +
//                                                                "maticbusd@miniTicker/" +
//                                                                "avaxbusd@miniTicker/" +
//                                                                "xrpbusd@miniTicker/" +
//                                                                "busdusdt@miniTicker"
//        val serverUrl:String = "wss://stream.binance.com:9443/ws/btcusdt@miniTicker"
        var wsListener = WSListener(this)
        var request: Request = Request.Builder().url(serverUrl).build()
        var webSocket: WebSocket = client.newWebSocket(request,wsListener)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateCoins(coin: CoinCrypto){
        var price:Double = coin.price.toDouble()
        if (countryArg){
            price *= CCL
        }
        val roundOff = String.format("%.4f",price)
        coin.price = roundOff
//        coin.percentage = "$priceChangePercentage%"
        this.activity?.runOnUiThread {
            coinsController.updateListCoin(coin)
            coinRecyclerAdapter.notifyDataSetChanged()
        }


    }


}