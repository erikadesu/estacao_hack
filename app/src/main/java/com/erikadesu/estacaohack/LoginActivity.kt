package com.erikadesu.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // quando clicar no botao sign in
        btnLoginSignIn.setOnClickListener {

            // capturar dados do user
            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val password = edtLoginPassword.text.toString().trim()

            // validacao dos campos
            if (email.isEmpty()) {
                edtLoginEmail.error = "Required field"
                edtLoginEmail.requestFocus()
            } else if (password.isEmpty()) {
                edtLoginPassword.error = "Required field"
                edtLoginPassword.requestFocus()
            } else {
                Toast.makeText(this, "Email or password invalid", Toast.LENGTH_LONG).show()
            }
        }
        // quando clicar no botao cadastrar
        btnLoginSignUp.setOnClickListener {
            val mIntent = Intent(this, SignUpActivity::class.java) //parametros: em que classe estamos e pra qual classe vamos
            startActivity(mIntent)
        }
    }
}