package com.example.easymoney.model

class Coin (

    var name:String? = "Dolar",
    var valueCoin:Int?= 10

){
    override fun toString(): String {
        return name!!
    }
}
