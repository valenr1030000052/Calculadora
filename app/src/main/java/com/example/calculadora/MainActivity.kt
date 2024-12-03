package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // 0->nada; 1->suma; 2->resta; 3->multiplicación; 4->división
    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIgual: Button = findViewById(R.id.btnIgual)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)

        btnIgual.setOnClickListener {
            val num2 = tv_num2.text.toString().toDoubleOrNull() ?: 0.0
            var res = 0.0
            when (oper) {
                1 -> res = numero1 + num2
                2 -> res = numero1 - num2
                3 -> res = numero1 * num2
                4 -> {
                    if (num2 != 0.0) {
                        res = numero1 / num2
                    } else {
                        res = 0.0  // Si se intenta dividir por cero, el resultado es 0
                    }
                }
            }
            tv_num2.text = res.toString()
            tv_num1.text = ""
            oper = 0 // Resetear la operación
        }

        btnBorrar.setOnClickListener {
            tv_num1.text = ""
            tv_num2.text = ""
            oper = 0
        }
    }

    fun clicNumero(view: View) {
        var num2 = tv_num2.text.toString()

        // No permitir agregar múltiples puntos
        if (view.id == R.id.btnPunto && num2.contains(".")) return

        when (view.id) {
            R.id.btn0 -> tv_num2.text = num2 + "0"
            R.id.btn1 -> tv_num2.text = num2 + "1"
            R.id.btn2 -> tv_num2.text = num2 + "2"
            R.id.btn3 -> tv_num2.text = num2 + "3"
            R.id.btn4 -> tv_num2.text = num2 + "4"
            R.id.btn5 -> tv_num2.text = num2 + "5"
            R.id.btn6 -> tv_num2.text = num2 + "6"
            R.id.btn7 -> tv_num2.text = num2 + "7"
            R.id.btn8 -> tv_num2.text = num2 + "8"
            R.id.btn9 -> tv_num2.text = num2 + "9"
            R.id.btnPunto -> tv_num2.text = num2 + "."
        }
    }

    fun clicOperacion(view: View) {
        val num2 = tv_num2.text.toString()

        // Evitar operaciones sin números
        if (num2.isEmpty()) return

        numero1 = num2.toDouble()
        tv_num2.text = ""

        when (view.id) {
            R.id.btnSumar -> {
                tv_num1.text = num2 + "+"
                oper = 1
            }
            R.id.btnRestar -> {
                tv_num1.text = num2 + "-"
                oper = 2
            }
            R.id.botnMult -> {
                tv_num1.text = num2 + "*"
                oper = 3
            }
            R.id.btnDividir -> {
                tv_num1.text = num2 + "/"
                oper = 4
            }
        }



    }
}
