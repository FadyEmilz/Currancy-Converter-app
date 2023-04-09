package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    var dollar = "Dollar"
    var egypion_pound = "Egypion Pound"
    var AED ="AED"
    var GBP = "GBP"
    var Euro = "Euro"


    var values = mapOf(
        dollar to 1.0,
        egypion_pound to 30.91,
        AED to 3.67,
        GBP to 0.84,
        Euro to 0.95
    )

    lateinit var btn : Button
    lateinit var lista1 : AutoCompleteTextView
    lateinit var lista2 : AutoCompleteTextView
    lateinit var input_et : TextInputEditText
    lateinit var output_et : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var_imple()
        make_adapter()

        btn.setOnClickListener {
            if(input_et.text.isNullOrEmpty()==true){
                var snakbar = Snackbar.make(btn,"Please Enter the amount ", Snackbar.LENGTH_SHORT)
                snakbar.setAction("Ok"){
                    input_et.setError("Required")

                }
                snakbar.show()
            }
            else{
                var amount = input_et.text.toString().toDouble()
                var from_valou = values[lista1.text.toString()]
                var to_valou = values[lista2.text.toString()]
                var result = (amount * to_valou!!)/ from_valou!!
                var format_result = String.format("%.4f",result)
                output_et.setText(format_result.toString())
            }


        }
    }


    private fun var_imple(){
        btn = findViewById(R.id.btn)
        lista1 = findViewById(R.id.menu_dropdown1)
        lista2 = findViewById(R.id.menu_dropdown2)
        input_et = findViewById(R.id.input_ed)
        output_et = findViewById(R.id.output_ed)
    }

    private fun make_adapter(){
       var list_of_countries = listOf(dollar,egypion_pound,AED,GBP,Euro)
        val adapter = ArrayAdapter(this,R.layout.drop_down_menu,list_of_countries)
        lista1.setAdapter(adapter)
        lista2.setAdapter(adapter)
    }

}