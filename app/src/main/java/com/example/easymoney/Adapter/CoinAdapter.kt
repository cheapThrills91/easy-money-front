package com.example.easymoney.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easymoney.Model.Coin
import com.example.easymoney.R
import kotlinx.android.synthetic.main.coin_type.view.*

class CoinAdapter(private var listCoin: List<Coin>): RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.coin_type,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listCoin.size
    }

    override fun onBindViewHolder(viewHolder: CoinViewHolder, position: Int) {
        viewHolder.bind(listCoin.get(position))
    }

    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(coin: Coin) {
            itemView.textCoinType.text = coin.name
            configState(coin)
            itemView.profile_image.setOnClickListener{
                coin.stateButton = !(coin.stateButton)
                configState(coin)
            }
            itemView.setOnClickListener {
                coin.stateButton = !(coin.stateButton)
                configState(coin)
            }
        }

        fun configState(coin: Coin) {
            if (coin.stateButton) {
                itemView.profile_image.background =itemView.context.getDrawable(R.drawable.ic_ball_check)
            } else {
                itemView.profile_image.setBackgroundResource(R.drawable.ic_ball)
            }
        }

    }
}