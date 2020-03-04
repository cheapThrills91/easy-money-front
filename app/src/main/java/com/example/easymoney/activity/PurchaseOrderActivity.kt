package com.example.easymoney.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import com.example.easymoney.R
import com.example.easymoney.model.Coin
import com.example.easymoney.network.ApiClient
import com.example.easymoney.util.FileUtil
import com.example.easymoney.util.Mask

import kotlinx.android.synthetic.main.activity_purchase_order.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PurchaseOrderActivity : AppCompatActivity() {

    private val listViews = ArrayList<EditText>()
    private var coins = ArrayList<Coin>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_order)

        getData()

        edDataDesejada.addTextChangedListener(Mask.mask("##/##/####", edDataDesejada))


    }

    private fun setupSpinner(){

        val listCoin = listOf(coins.indices)
        var spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, coins)

        coin_spinner.adapter = spinnerAdapter

        coin_spinner.setSelection(spinnerAdapter.count)

        configView()

    }

    private fun configView() {

        bCadastroOrdem.setOnClickListener { effectiveOrder() }

        listViews.add(edDataDesejada)
        listViews.add(edQtoCoin)
        listViews.add(edCoin)

    }


    private fun effectiveOrder() {

        val returnText = StringBuilder()
        for (view in listViews) {
            if(returnText.append(valida(view)).isNotEmpty())
                break
        }

        if (returnText.isNotEmpty()) {
            Toast.makeText(this, returnText, Toast.LENGTH_LONG).show()
        } else {
            showDialogSuccess()
        }

    }


    private fun showDialogSuccess() {

        val builder = AlertDialog.Builder(this@PurchaseOrderActivity)

        builder.setTitle("Ordem cadastrada com sucesso")
        builder.setMessage("Ordem 1 criada até ${edDataDesejada.text} ")

        builder.setPositiveButton("ok") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()

        edDataDesejada.text.clear()
        edCoin.text.clear()
        edQtoCoin.text.clear()
    }

    private fun valida(field: EditText): String {

        when (field.id) {
            edDataDesejada.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo data não pode estar vazio"
            }
            edCoin.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo valor de compra não pode estar vazio"
            }

            edQtoCoin.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo quantidade não pode estar vazio"
            }
        }

        return ""

    }

    private fun getData() {
        val call: Call<List<Coin>> = ApiClient.getClient.getCoins()
        call.enqueue(object : Callback<List<Coin>> {

            override fun onResponse(call: Call<List<Coin>>, response: Response<List<Coin>>) {
                response.body()?.let { coins.addAll(it) }

            }

            override fun onFailure(call: Call<List<Coin>>?, t: Throwable?) {
                coins.addAll(FileUtil.getCoin())

            }
        })

        setupSpinner()
    }


}
