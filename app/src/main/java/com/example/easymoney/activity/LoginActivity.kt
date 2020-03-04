package com.example.easymoney.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.easymoney.R
import com.example.easymoney.exceptions.LoginException
import com.example.easymoney.infrastructure.LoginRepository
import com.example.easymoney.infrastructure.LoginRepositoryImpl
import com.example.easymoney.model.Login
import com.example.easymoney.util.FileUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginRepository : LoginRepository
    private lateinit var login : Login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginRepository = LoginRepositoryImpl(FileUtil.getInstance())


        btnLogin.setOnClickListener{

            val name = etUsername.text.toString()
            val password = etPassword.text.toString()

            login = Login(name, password)

            try {
                var retorno = loginRepository.login(login)
                Toast.makeText(this, "Login encontrado", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, PurchaseOrderActivity::class.java))
            }catch (ex:LoginException){
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
            }

        }

        textRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
}
