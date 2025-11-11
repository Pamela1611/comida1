package com.matamoros.mamarufy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val n1=findViewById<EditText>(R.id.txt_n1)
        val n2=findViewById<EditText>(R.id.txt_n2)
        val r=findViewById<TextView>(R.id.txt_resultado)
        val btn_s=findViewById<Button>(R.id.btn_sumar)


        btn_s.setOnClickListener {
            val num1 = n1.text.toString().toIntOrNull()?: 0
            val num2 = n2.text.toString().toIntOrNull()?: 0
            val resultado=sumar(num1, num2)
            r.text = "La suma es:  $resultado"
        }




    }
    private fun sumar (a: Int, b: Int):Int{
        return a + b
    }
}