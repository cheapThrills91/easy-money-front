package com.example.easymoney.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easymoney.R
import com.example.easymoney.model.PurchaseOrder
import kotlinx.android.synthetic.main.pucharse_order.view.*

class PurchaseOrderItemAdapter(private var listOrderItem: List<PurchaseOrder>): RecyclerView.Adapter<PurchaseOrderItemAdapter.PrchaseOrderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrchaseOrderViewHolder {
        return PrchaseOrderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.pucharse_order,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOrderItem.size
    }

    override fun onBindViewHolder(viewHolder: PrchaseOrderViewHolder, position: Int) {
        viewHolder.bind(listOrderItem[position])
    }

    class PrchaseOrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(purchaseOrder: PurchaseOrder) {
            itemView.textPurchaseOrderType.text = itemView.context.resources.getString(
                R.string.item_purchase_order,
                purchaseOrder.orderId.toString(),
                purchaseOrder.coin.name,
                purchaseOrder.valueValorCompra.toString())
            itemView.setOnClickListener {

            }
        }


    }
}