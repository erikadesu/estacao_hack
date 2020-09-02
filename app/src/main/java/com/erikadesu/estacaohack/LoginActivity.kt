package com.erikadesu.estacaohack

import android.content.Context
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
                //acessando o arquivo de shared prefs
                val sharedPrefs = getSharedPreferences("sign_up_$email", Context.MODE_PRIVATE)

                // retrieving data from shared prefs
                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val passwordPrefs = sharedPrefs.getString("PASSWORD", "")

                // verify user's email and password
                if (email == emailPrefs && password == passwordPrefs) {
                    Toast.makeText(this, "You are now logged in!", Toast.LENGTH_LONG).show()

                    // opens main activity
                    val mIntent = Intent(this, MainActivity::class.java)

                    //sending the email to main activity - putExtra for when i wanna send a variable to another screen
                    mIntent.putExtra("INTENT_EMAIL", email)
                    startActivity(mIntent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_LONG).show()
                }
            }
        }
        // quando clicar no botao cadastrar
        btnLoginSignUp.setOnClickListener {
            val mIntent = Intent(this, SignUpActivity::class.java) //parametros: em que classe estamos e pra qual classe vamos
            startActivity(mIntent)
        }
    }
}