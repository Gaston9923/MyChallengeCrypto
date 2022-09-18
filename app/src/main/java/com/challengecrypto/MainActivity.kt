package com.challengecrypto

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.challengecrypto.Adapters.MyAdapter
import com.challengecrypto.Fragments.ConfiguracionFragment
import com.challengecrypto.Fragments.HomeFragment
import com.challengecrypto.Fragments.MovimientosFragment
import com.challengecrypto.Models.ExchangeInfo
import com.challengecrypto.Models.ResponsePrice
import com.challengecrypto.Models.SymbolCrypto
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {



    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout:TabLayout = findViewById(R.id.tab_layout)
        val  viewPager:ViewPager2 = findViewById(R.id.viewPager2)

        val fragments: ArrayList<Fragment> = arrayListOf(
            HomeFragment(),MovimientosFragment(), ConfiguracionFragment()
        )

        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        val adapter = MyAdapter(this, fragments)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){ tab,position ->
        when(position){
            0 -> {
                tab.text = "Home"
                tab.setIcon(R.drawable.icons8_menu_64)
            }
            1 -> {
                tab.text = "Movimientos"
                tab.setIcon(R.drawable.icons8_financial_changes_32)
            }
            2 -> {
                tab.text = "Configuracion"
                tab.setIcon(R.drawable.icons8_settings_24)
            }
        }
        }.attach()

        val btnConnect: Button = findViewById(R.id.btn_connect)
        val btnSend: Button = findViewById(R.id.btn_send)
        val btnClose: Button = findViewById(R.id.btn_close)


//
        btnSend.setOnClickListener{
            getCoinInfo()
        }
//        getResponse()
//        getDataApi()
//        getPriceCrypto()
    }


    private fun getResponse(){
        CryptoDbClient.service.get24hrPriceStatistics().enqueue(object : Callback<List<ResponsePrice>>{
            override fun onResponse(call: Call<List<ResponsePrice>>, response: Response<List<ResponsePrice>>) {
                println("Call: "+call+"::  "+response.body().toString())
            }

            override fun onFailure(call: Call<List<ResponsePrice>>, t: Throwable) {
                println("Error: $t")
            }

        })
    }

    private fun getCoinInfo(){
        CryptoDbClient.service.getCoinInfo().enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("Call: "+call+"::  "+response.body().toString())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                println("Error: $t")
            }

        })
    }

    private fun getDataApi(){
        CryptoDbClient.service.getExchangeInfo().enqueue(object : Callback<ExchangeInfo>{
            override fun onResponse(call: Call<ExchangeInfo>, response: Response<ExchangeInfo>) {
                println(response.body().toString())
            }

            override fun onFailure(call: Call<ExchangeInfo>, t: Throwable) {
                println("Error: $t")
            }

        })
    }

    private fun getPriceCrypto(){
        CryptoDbClient.service.getPriceSymbols().enqueue(object : Callback<List<SymbolCrypto>>{
            override fun onResponse(call: Call<List<SymbolCrypto>>, response: Response<List<SymbolCrypto>>) {
                println("Response:"+response.body().toString())
            }

            override fun onFailure(call: Call<List<SymbolCrypto>>, t: Throwable) {
                println("Error: $t")
            }

        })
    }



}