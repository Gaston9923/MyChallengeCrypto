package com.challengecrypto

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.challengecrypto.Adapters.MyAdapter
import com.challengecrypto.Fragments.ConfiguracionFragment
import com.challengecrypto.Fragments.HomeFragment
import com.challengecrypto.Fragments.MovimientosFragment
import com.challengecrypto.Models.ExchangeInfo
import com.challengecrypto.Models.SymbolCrypto
import com.challengecrypto.Models.Ticker
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout:TabLayout = findViewById(R.id.tab_layout)
        val  viewPager:ViewPager2 = findViewById(R.id.viewPager2)

        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        val fragments: ArrayList<Fragment> = arrayListOf(
            HomeFragment(),MovimientosFragment(), ConfiguracionFragment()
        )
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
    }






}