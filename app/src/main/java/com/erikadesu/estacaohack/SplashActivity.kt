package com.erikadesu.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // para abrir a MainActivity após 5 segundos
        Handler(Looper.getMainLooper()).postDelayed({
           // vou iniciar um intent - transição da tela splash para a tela main
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent) //vai iniciar uma tela
            finish() //mata a tela, user não pode mais voltar nela
        }, 5000) //postDelayed trabalha com milisegundos
    }
}