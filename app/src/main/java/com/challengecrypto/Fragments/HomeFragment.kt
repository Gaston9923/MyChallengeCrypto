package com.challengecrypto.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.challengecrypto.Adapters.CoinsRecyclerAdapter
import com.challengecrypto.Adapters.SpinnerAdapter
import com.challengecrypto.Controllers.CoinsController
import com.challengecrypto.Models.CoinCrypto
import com.challengecrypto.R
import com.challengecrypto.WSListener
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import java.util.concurrent.TimeUnit

class HomeFragment() : Fragment() {
    private val coinsController = CoinsController()
    private lateinit var rvCoins: RecyclerView
    private val coinRecyclerAdapter = CoinsRecyclerAdapter(coinsController)
    private var countryArg = true
    private lateinit var loader : ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val context:Context = this.requireContext()
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        val spinner:Spinner = view.findViewById(R.id.sp_cotizacion)
        loader = view.findViewById(R.id.progressBar)
        rvCoins = view.findViewById(R.id.rv_coins)
        rvCoins.layoutManager = GridLayoutManager(this.requireContext(),1)
        rvCoins.setHasFixedSize(true)
        rvCoins.adapter = coinRecyclerAdapter

        var integers = arrayOf<Int>(R.drawable.bandera_argentina_icon, R.drawable.bandera_eeuu_icon)
        var strings = arrayOf("Cotizaciones en Pesos Argentinos", "Cotizaciones en Dolares")
        var myAdapter = SpinnerAdapter(this.requireContext(), strings,integers)
        myAdapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = myAdapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                val icon = view?.findViewById(R.id.iv_icon) as ImageView
                if (position == 0){
                    icon.setImageResource(R.drawable.bandera_argentina_icon)
                }else{
                    icon.setImageResource(R.drawable.bandera_eeuu_icon)
                }
                countryArg = if(position == 0 ) true else false
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        startWebSocket()
        return view
    }



    @SuppressLint("NotifyDataSetChanged")
    private fun startWebSocket(){
        val client = OkHttpClient().newBuilder().writeTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS).readTimeout(40, TimeUnit.SECONDS).build()
        val serverUrl:String = "wss://stream.binance.com:9443/ws/btcbusd@ticker/" +
                                                                "bnbbusd@ticker/" +
                                                                "ethbusd@ticker/" +
                                                                "lunabusd@ticker/" +
                                                                "solbusd@ticker/" +
                                                                "ltcbusd@ticker/" +
                                                                "maticbusd@ticker/" +
                                                                "avaxbusd@ticker/" +
                                                                "xrpbusd@ticker/" +
                                                                "busdusdt@ticker"
        var wsListener = WSListener(this)
        var request: Request = Request.Builder().url(serverUrl).build()
        var webSocket: WebSocket = client.newWebSocket(request,wsListener)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateCoins(coin: CoinCrypto){
        this.activity?.runOnUiThread {
            coinsController.updateListCoin(coin, countryArg)
            coinRecyclerAdapter.notifyDataSetChanged()
            loader.visibility = View.INVISIBLE
            rvCoins.visibility = View.VISIBLE
        }

    }

    override fun onResume() {
        super.onResume()
        startWebSocket()
    }
}