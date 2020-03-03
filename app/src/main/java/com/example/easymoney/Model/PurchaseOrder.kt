package com.example.easymoney.Model

data class PurchaseOrder (
    val orderId:Int = 1,
    val coin: Coin = Coin(),
    val valueDesejada:Int = 0,
    val valueValorCompra:Double = 10.0,
    val valueQuantidadeValor:Double= 5.0
)

