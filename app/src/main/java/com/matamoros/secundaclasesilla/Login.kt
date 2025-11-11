package com.matamoros.secundaclasesilla

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.matamoros.secundaclasesilla.MainActivity
import com.matamoros.secundaclasesilla.Registrar

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val btn_login=findViewById<Button>(R.id.btnLogin)

        btn_login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }
        val etCorreoLogin = findViewById<EditText>(R.id.etCorreoLogin)
        val etContrasenaLogin = findViewById<EditText>(R.id.etContrasenaLogin)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnIrRegistro = findViewById<Button>(R.id.btnIrRegistro)

        btnLogin.setOnClickListener {
            val correo = etCorreoLogin.text.toString().trim()
            val contrasena = etContrasenaLogin.text.toString().trim()

            val prefs = getSharedPreferences("datos_usuario", Context.MODE_PRIVATE)
            val correoGuardado = prefs.getString("correo", "")
            val contrasenaGuardada = prefs.getString("contrasena", "")
            val nombreGuardado = prefs.getString("nombre", "")

            if (correo == correoGuardado && contrasena == contrasenaGuardada) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("nombre_usuario", nombreGuardado)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        btnIrRegistro.setOnClickListener {
            startActivity(Intent(this, Registrar::class.java))
        }

    }
}
