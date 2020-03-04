package com.example.easymoney.network

import com.example.easymoney.model.Coin
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("coins")
    fun getCoins(): Call<List<Coin>>

}