package com.example.easymoney.model

class Login (
    var user:String? = "admin",
    var passWord:String? = "admin"
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Login

        if (user != other.user) return false
        if (passWord != other.passWord) return false

        return true
    }

    override fun hashCode(): Int {
        var result = user?.hashCode() ?: 0
        result = 31 * result + (passWord?.hashCode() ?: 0)
        return result
    }
}
