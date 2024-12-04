package com.c14220188.latihandaftarpekerjaan

import android.content.Intent
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class addPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var _namaTask = findViewById<EditText>(R.id.namaTask)
        var _tanggalTask = findViewById<EditText>(R.id.tanggalTask)
        var _kategoriTask = findViewById<EditText>(R.id.kategoriTask)
        var _deskripsiTask = findViewById<EditText>(R.id.deskripsiTask)
        var _btnSimpan = findViewById<Button>(R.id.btnSimpan)
        var intent = intent.getParcelableExtra<task>("kirimDataEdit", task::class.java)

        if (intent != null) {
            _namaTask.setText(intent.nama)
            _tanggalTask.setText(intent.tanggal)
            _kategoriTask.setText(intent.kategori)
            _deskripsiTask.setText(intent.deskripsi)

            _btnSimpan.setOnClickListener {
                val nama = _namaTask.text.toString()
                val tanggal = _tanggalTask.text.toString()
                val kategori = _kategoriTask.text.toString()
                val deskripsi = _deskripsiTask.text.toString()

                val dataKirim =
                    task(nama, tanggal, kategori, deskripsi)

                val intent = Intent(this@addPage, MainActivity::class.java).apply {
                    putExtra("editData", dataKirim)
                }
                startActivity(intent)
                finish()
            }
        } else {
            _btnSimpan.setOnClickListener {
                val nama = _namaTask.text.toString()
                val tanggal = _tanggalTask.text.toString()
                val kategori = _kategoriTask.text.toString()
                val deskripsi = _deskripsiTask.text.toString()

                val dataKirim =
                    task(nama, tanggal, kategori, deskripsi)

                val intent = Intent(this@addPage, MainActivity::class.java).apply {
                    putExtra("editData", dataKirim)
                }
                startActivity(intent)
                finish()
            }
        }
    }
}