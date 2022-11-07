package com.example.b2_2003040135_muhammadulilazmi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtPoint: EditText
    private lateinit var edtSKS: EditText
    private lateinit var btnHitung: Button
    private lateinit var edtAkhir: TextView
    private lateinit var edtHuruf: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        edtPoint = findViewById(R.id.edt_Point)
        edtSKS = findViewById(R.id.edt_SKS)
        btnHitung = findViewById(R.id.btn_Hitung)
        edtAkhir = findViewById(R.id.edt_Akhir)
        edtHuruf = findViewById(R.id.edt_Huruf)

        btnHitung.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_Hitung) {
            val inputPoint = edtPoint.text.toString().trim()
            val inputSKS = edtSKS.text.toString().trim()

            var isEmptyFields = false

            if (inputPoint.isEmpty()) {
                isEmptyFields = true
                edtPoint.error = "Field ini tidak boleh kosong"
            }
            if (inputSKS.isEmpty()) {
                isEmptyFields = true
                edtSKS.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyFields) {
                val volume = inputPoint.toDouble() * inputSKS.toDouble() / inputSKS.toDouble()
                var huruf = volume.toString()

                if (volume >= 86 && volume <= 100) {
                    huruf = "A"
                } else if (volume >= 81 && volume <= 85) {
                    huruf = "A-"
                } else if (volume >= 76 && volume <= 80) {
                    huruf = "B+"
                } else if (volume >= 71 && volume <= 75) {
                    huruf = "B"
                } else if (volume >= 66 && volume <= 70) {
                    huruf = "B-"
                } else if (volume >= 61 && volume <= 65) {
                    huruf = "C+"
                } else if (volume >= 56 && volume <= 60) {
                    huruf = "C"
                } else if (volume >= 41 && volume <= 55) {
                    huruf = "D"
                } else if (volume >= 0 && volume <= 40) {
                    huruf = "E"
                }
                edtAkhir.text = volume.toString()
                edtHuruf.text = huruf
            }
        }
    }
}