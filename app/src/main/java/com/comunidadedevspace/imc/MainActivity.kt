package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // setContentView serve para conectar mainActivity com Activity_main.xml

        // Recuperar os componenetes EditText ( usando o código findViewById )
        // Criar uma variavel e associar o componente de UI <TextInputEditText>
        // Recuperar o botão da tela
        // Colocar ação no botão
        // Recuperar texto digitado no edt peso

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso) // findViewById serve para recuperar o arquivo dentro do Xml
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura) // dentro do <> vai todos os tipos de View
        val btnCalcular =  findViewById<Button>(R.id.btn_calcular) // dentro do () é inserido o valor do ID

        btnCalcular.setOnClickListener { // setOnClickListener serve para colocar um click no botão
            
            val pesoStr: String = edtPeso.text.toString() // .text serve para recuperar o texto e colocar na variavel
            val alturaStr: String = edtAltura.text.toString() // toString para permitir apenas numeros

            if (pesoStr == "" || alturaStr == ""){ // "" para verificar se esta vazio

                Snackbar // serve para criar mensagens para mostrar ao usuarios, tipo avisos
                    .make( // complemento para criação do Snackbar
                        edtPeso, "Preencha todos os campos",
                        Snackbar.LENGTH_LONG) // é o tempo
                    .show() // para mostrar mesmo de fato
            } else {
                val peso = pesoStr.toFloat() // convertendo para texto
                val altura = alturaStr.toFloat() // convertendo para texto

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                // Intent é uma classe do próprio android e ela serve para declarar a inteção de fazer alguma no sistema operacional do android

                val intent =  Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado) // serve para passar os dados para próxima tela
                startActivity(intent)

                // Navegar para próxima tela = ok
                // Criar o layout da próxima tela = ok
                // Passar dados para próxima tela
                // Cores
                // EdiText background + icone
                // Gradiente + icone + titulo + descrição

            }

        }
    }
}