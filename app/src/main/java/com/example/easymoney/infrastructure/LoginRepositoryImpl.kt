package com.example.easymoney.infrastructure

import com.example.easymoney.exceptions.LoginException
import com.example.easymoney.model.Login
import com.example.easymoney.util.FileUtil

class LoginRepositoryImpl(private var fileUtil:FileUtil) : LoginRepository {

    @Throws(LoginException::class)
    override fun login(login: Login): Login {

        val logins = fileUtil.getLogins()

        if(logins.contains(login)){
            return login
        }else{
            throw LoginException("Usuário ou senha incorretos")
        }

    }

}