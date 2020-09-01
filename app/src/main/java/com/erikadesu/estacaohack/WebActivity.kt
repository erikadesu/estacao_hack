package com.erikadesu.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //habilitando execucao de codigoo javascript
        wbvSite.settings.javaScriptEnabled = true

        //carregando site
        wbvSite.loadUrl("http://br.cellep.com/estacaohack")

        //definindo nosso webview como cliente web padrao
        wbvSite.webViewClient = WebViewClient()
    }
}