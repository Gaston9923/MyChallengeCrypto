package com.challengecrypto.Fragments

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
import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.R
import com.challengecrypto.WSListener
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import java.util.concurrent.TimeUnit

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val context:Context = this.requireContext()
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        val spinner:Spinner = view.findViewById(R.id.sp_cotizacion)
        val rvCoins: RecyclerView = view.findViewById(R.id.rv_coins)

        rvCoins.layoutManager = GridLayoutManager(this.requireContext(),1)
        rvCoins.setHasFixedSize(true)
        val coinList = mutableListOf<CoinCrypto>()
        coinList.add(CoinCrypto("BTC","Bitcoin","40.454,85","+9.1%"))
        coinList.add(CoinCrypto("BNB","BinanceCoin","280.01","+8.1%"))
        val coinRecyclerAdapter = CoinsRecyclerAdapter(coinList)
        rvCoins.adapter = coinRecyclerAdapter

        ArrayAdapter.createFromResource(context,R.array.cotizaciones,android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                val selectedItem = parent!!.getItemAtPosition(position).toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        startWebSocket()
        return view
    }

    private fun getPrice(){

    }

    private fun startWebSocket(){
        val client = OkHttpClient().newBuilder().writeTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS).readTimeout(40, TimeUnit.SECONDS).build()
//        val serverUrl:String = "wss://stream.binance.com:9443/ws/bnbbusd@trade"
//        val serverUrl:String = "wss://stream.binance.com:9443/ws/btcusdt@trade"
//        val serverUrl:String = "wss://stream.binance.com:9443/ws/!miniTicker@arr"
        val serverUrl:String = "wss://stream.binance.com:9443/ws/btcusdt@miniTicker/" +
                                                                "bnbbusd@miniTicker/" +
                                                                "ethbusd@miniTicker/" +
                                                                "lunabusd@miniTicker/" +
                                                                "solbusd@miniTicker/" +
                                                                "ltcbusd@miniTicker/" +
                                                                "maticbusd@miniTicker/" +
                                                                "avaxbusd@miniTicker/" +
                                                                "xrpbusd@miniTicker/" +
                                                                "busdusdt@miniTicker"
        var wsListener = WSListener()
        var request: Request = Request.Builder().url(serverUrl).build()
        var webSocket: WebSocket = client.newWebSocket(request,wsListener)
    }



}