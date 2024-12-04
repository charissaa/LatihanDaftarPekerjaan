package com.c14220188.latihandaftarpekerjaan

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        var _rvTask = findViewById<RecyclerView>(R.id.rvTask)

        fun SiapkanData() {
            _nama = resources.getStringArray(R.array.namaTask)
            _tanggal = resources.getStringArray(R.array.tanggalTask)
            _kategori = resources.getStringArray(R.array.kategoriTask)
            _deskripsi = resources.getStringArray(R.array.deskripsiTask)
        }

        fun TambahData() {
            for (position in _nama.indices) {
                val data = task(
                    _nama[position],
                    _tanggal[position],
                    _kategori[position],
                    _deskripsi[position]
                )
                arTask.add(data)
            }
        }

        fun TampilkanData() {
            _rvTask.layoutManager = LinearLayoutManager(this)
            _rvTask.adapter = adapterRecView(arTask)
        }

        _rvTask = findViewById<RecyclerView>(R.id.rvTask)
        SiapkanData()
        TambahData()
        TampilkanData()
    }

    private lateinit var _nama : Array<String>
    private lateinit var _tanggal : Array<String>
    private lateinit var _kategori : Array<String>
    private lateinit var _deskripsi : Array<String>

    private var arTask = arrayListOf<task>()
}