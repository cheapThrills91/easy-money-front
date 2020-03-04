package com.example.easymoney.util

import com.example.easymoney.model.Coin
import com.example.easymoney.model.Login
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader

object FileUtil {

    fun getInstance():FileUtil{
        return this
    }

    private val COIN_TYPE = object : TypeToken<List<Coin>>() {}.type
    private val LOGIN_TYPE = object : TypeToken<List<Login>>() {}.type
    private const val COIN_FILE = "coin_file.json"
    private const val LOGIN_FILE = "login_file.json"

    fun getCoin(): List<Coin> {

        val file = readFile(COIN_FILE)

        return Gson().fromJson<Any>(file, COIN_TYPE) as List<Coin>
    }

    fun getLogins(): List<Login> {

        val file = readFile(LOGIN_FILE)

        return Gson().fromJson<Any>(file, LOGIN_TYPE) as List<Login>

    }

    private fun readFile(file: String): Reader {
        val inputStream = this.javaClass.classLoader.getResourceAsStream(file)

        return BufferedReader(InputStreamReader(inputStream))
    }

}