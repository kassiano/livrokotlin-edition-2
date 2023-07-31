package br.com.livrokotlin.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*

class MainActivity: Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo o arquivo de layout
        setContentView(R.layout.activity_main)

        val spinnerSexo = findViewById<Spinner>(R.id.spinner_sexo)

        //acessando a caixa de idade
        val editTextIdade = findViewById<EditText>(R.id.edit_text_idade)

        //acessando o botão de calcular
        val buttonCalcular = findViewById<Button>(R.id.button_calcular)

        //acessando o texto de resultado
        val textViewResultado = findViewById<TextView>(R.id.text_view_resultado)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("masculino", "feminino")
        )
        spinnerSexo.adapter = adapter

        buttonCalcular.setOnClickListener {
            //aqui vai o código que será executado quando houver um click do botão
            val sexoSelecionado = spinnerSexo.selectedItem as String
            val idade = editTextIdade.text.toString().toInt()

            var resultado = 0
            if (sexoSelecionado == "masculino") {
                resultado = 65 - idade
            } else {
                resultado = 60 - idade
            }

            textViewResultado.text = "Faltam $resultado anos para você se aposentar."
        }

    }
}