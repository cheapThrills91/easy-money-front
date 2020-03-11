package com.example.easymoney.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.easymoney.R
import com.example.easymoney.adapter.PurchaseOrderItemAdapter
import com.example.easymoney.model.Coin
import com.example.easymoney.model.PurchaseOrder
import kotlinx.android.synthetic.main.activity_purchase_order_list.*

class PurchaseOrderListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_order_list)

        recycler_purchase_order_list.layoutManager = LinearLayoutManager(this)
        recycler_purchase_order_list.setHasFixedSize(true)

        var purchaseOrderItemAdapter = PurchaseOrderItemAdapter(getListPurchaseOrderItem())
        recycler_purchase_order_list.adapter = purchaseOrderItemAdapter

        btnNewOrder.setOnClickListener {
            startActivity(Intent(this, PurchaseOrderActivity::class.java))
        }
    }

    fun getListPurchaseOrderItem(): List<PurchaseOrder> {


        var coin = Coin()
        coin.name = "Dolar"


        var listOrderItem = PurchaseOrder(
            1,
            coin,
            10,
            20.0,
            5.0
        )

        var listOrderItem2 = PurchaseOrder(
            2,
            coin,
            10,
            30.0,
            5.0
        )

        return listOf(listOrderItem, listOrderItem2)

    }
}
