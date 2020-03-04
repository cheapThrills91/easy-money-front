package com.example.easymoney.infrastructure

import com.example.easymoney.model.Login

interface LoginRepository{

    fun login(login: Login): Login

}