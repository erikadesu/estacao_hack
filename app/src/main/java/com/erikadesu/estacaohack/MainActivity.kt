package com.erikadesu.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperando o email passado por meio da intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        // acessar o arquivo de preferencias compartilhadas
        val sharedPrefs = getSharedPreferences("sign_up_$email", Context.MODE_PRIVATE)

        // recuperar dados no arquivo shared prefs
        val first_name = sharedPrefs.getString("FIRST_NAME", "")
        val last_name = sharedPrefs.getString("LAST_NAME", "")
        val gender = sharedPrefs.getString("GENDER", "")

        // exibir dados recuperados na tela
        txvMainName.text = "$first_name $last_name"
        txvMainEmail.text = email
        txvMainGender.text = gender

        // botao quit
        btnMainQuit.setOnClickListener{
            //alerta
            AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Do you really wanna quit?")
                .setPositiveButton("Yes"){_,_ ->
                    // clique do botao sim
                    val mIntent = Intent(this, LoginActivity::class.java)
                    startActivity(mIntent)
                    finishAffinity()
                }
                .setNeutralButton("Cancel"){_,_ -> }
                .setCancelable(false) // se clicar fora cancela se for true, se for false forca user a clicar nas opcoes
                .create()
                .show() //mostra alerta na tela - podemos criar uma funcao ate a parte do create e chamar a funcao com o show
        }

        btnMainSite.setOnClickListener{
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }
    }
}