package com.example.easymoney.Model

class Coin (

    var name:String? = "Dolar",
    var valueCoin:Int?= 10

){
    override fun toString(): String {
        return name!!
    }
}
