package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "=ResultActivity.KEY_IMC" // é uma chave para puxar da outra tela

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)// para mostrar um valor minimo no pacote

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificação = findViewById<TextView>(R.id.tv_classificacão)

        tvResult.text = result.toString() // para converter a texto

        val (classificação, color) = when {
            result < 18.5f -> "MAGREZA" to R.color.red
            result > 18.5f && result <= 24.9f -> "NORMAL" to R.color.green
            result > 25f && result <= 29.9f -> "SOBREPESO" to R.color.yellow
            result > 30f && result <= 39f -> "OBESIDADE" to R.color.orange
            else -> "OBESIDADE GRAVE" to R.color.red

        }


        tvClassificação.text = classificação
        tvClassificação.setTextColor(ContextCompat.getColor(this,color))

    }
}