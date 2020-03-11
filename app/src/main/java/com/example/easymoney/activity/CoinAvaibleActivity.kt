package com.example.easymoney.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import com.example.easymoney.model.Coin
import com.example.easymoney.adapter.PurchaseOrderItemAdapter
import com.example.easymoney.R

import kotlinx.android.synthetic.main.activity_coin_avaible.*

class CoinAvaibleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_avaible)

        recycler_view_coin.setHasFixedSize(true)
        recycler_view_coin.layoutManager = LinearLayoutManager (this)

//        var coinAdapter = PurchaseOrderItemAdapter()

//        recycler_view_coin.adapter = coinAdapter

    }

    private fun getLista() : List<Coin>{


        var coin = Coin()
        coin.name = "Dolar"
        var coin2 = Coin()
        coin2.name = "Real"
        var coin3 = Coin()
        coin3.name = "Libra"

        var coinList = ArrayList<Coin>()
        coinList.add(coin)
        coinList.add(coin2)
        coinList.add(coin3)

        return coinList
    }


}
