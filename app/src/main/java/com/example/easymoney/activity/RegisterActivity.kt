package com.example.easymoney.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.Toast
import com.example.easymoney.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private val listViews = ArrayList<EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        configView()
    }

    private fun valida(field: EditText): String {

        when (field.id) {
            etName.editText?.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo nome não pode estar vazio"
            }
            etCPF.editText?.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo CPF não pode estar vazio"
            }

            etRG.editText?.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo RG não pode estar vazio"
            }

            etDataNascimento.editText?.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo data nascimento não pode estar vazio"
            }
            etNacionalidade.editText?.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo nacionalidade não pode estar vazio"
            }
            etUF.editText?.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo UF não pode estar vazio"
            }
            etEndereco.editText?.id -> {
                if (field.text.isNullOrEmpty())
                    return "Campo endereço não pode estar vazio"
            }
        }

        return ""

    }

    private fun configView() {

        listViews.add(etName.editText!!)
        listViews.add(etCPF.editText!!)
        listViews.add(etRG.editText!!)
        listViews.add(etNacionalidade.editText!!)
        listViews.add(etUF.editText!!)
        listViews.add(etEndereco.editText!!)

        bRegister.setOnClickListener{effectiveRegister()}

    }

    private fun effectiveRegister() {

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

        val builder = AlertDialog.Builder(this@RegisterActivity)

        builder.setTitle("Cadastro realizado com sucesso")

        builder.setPositiveButton("ok") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()

        clearView()

    }

    private fun clearView(){
        for(view in listViews){
            view.text.clear()
        }
    }
}
