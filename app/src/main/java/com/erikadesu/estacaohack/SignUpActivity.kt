package com.erikadesu.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //criando dropdown list para o spinner
        val genderList = arrayListOf("Select your gender", "male", "female", "other")

        //criando adaptador pra a lista e spinner
        val genderAdapter = ArrayAdapter(
            this, //contexto
            android.R.layout.simple_spinner_dropdown_item, //layout
            genderList //array
        )

        //linkar o adaptar no spinner
        spnSignUpGender.adapter = genderAdapter

        //executando o clique no botao sign up
        btnSignUpButton.setOnClickListener {
            //capturar dados digitados
            val firstName = edtSignUpFirstName.text.toString().trim()
            val lastName = edtSignUpLastName.text.toString().trim()
            val email = edtSignUpEmail.text.toString().trim().toLowerCase()
            val password = edtSignUpPassword.text.toString().trim()
            val gender = spnSignUpGender.selectedItem.toString()

            //validar os campos e salvar
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || gender == genderList[0]) {
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_LONG)
            } else {
                //getSharedPreferences gera um arquivo xml - nao colocar chars especiais
                val sharedPrefs = getSharedPreferences("signUp_$email", Context.MODE_PRIVATE ) // cria arquivo
                //editar o arquivo
                val editPrefs = sharedPrefs.edit()
                //preparando dados a serem salvos
                editPrefs.putString("FIRST_NAME", firstName)
                editPrefs.putString("LAST_NAME", lastName)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("GENDER", gender)

                editPrefs.apply() //salva dados no arquivo shared preferences
                val mIntent = Intent(this, MainActivity::class.java)

                //passando informações através da intent - passar o email do usuário pra outra tela

                mIntent.putExtra("INTENT_EMAIL", email) //permite passar com pequenos dados para outras telas
                startActivity(mIntent) //começa a activity com a info

                //tirando todas as telas do empilhamento
                finishAffinity()

            }

        }
    }
}