package com.c14220188.latihandaftarpekerjaan

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
        var intentAdd = intent.getParcelableExtra<task>("kirimData", task::class.java)
        var pos = intent.getIntExtra("pos", 0)
        var intentEdit = intent.getParcelableExtra<task>("editData", task::class.java)

        fun SiapkanData() {
            _nama = resources.getStringArray(R.array.namaTask).toMutableList()
            _tanggal = resources.getStringArray(R.array.tanggalTask).toMutableList()
            _kategori = resources.getStringArray(R.array.kategoriTask).toMutableList()
            _deskripsi = resources.getStringArray(R.array.deskripsiTask).toMutableList()
        }

        fun TambahData() {
            arTask.clear()
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

        fun EditData(data:task, pos:Int) {
            _nama[pos] = data.nama
            _tanggal[pos] = data.tanggal
            _kategori[pos] = data.kategori
            _deskripsi[pos] = data.deskripsi
        }

        fun TampilkanData() {
            _rvTask.layoutManager = LinearLayoutManager(this)

            val adapterTask = adapterRecView(arTask)
            _rvTask.adapter = adapterTask

            adapterTask.setOnItemClickCallback(object : adapterRecView.OnItemClickCallback {
                override fun editData(data: task, pos: Int) {

                }

                override fun delData(pos: Int) {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("HAPUS DATA")
                        .setMessage("Apakah Benar Data " + _nama[pos] + " Akan Dihapus ?")
                        .setPositiveButton(
                            "HAPUS",
                            DialogInterface.OnClickListener { dialog, which ->
                                _nama.removeAt(pos)
                                _tanggal.removeAt(pos)
                                _kategori.removeAt(pos)
                                _deskripsi.removeAt(pos)
                                TambahData()
                                TampilkanData()
                            }
                        )

                        .setNegativeButton(
                            "BATAL",
                            DialogInterface.OnClickListener { dialog, which ->
                                Toast.makeText(
                                    this@MainActivity,
                                    "Data Batal Dihapus",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        ).show()
                }
            })
        }

        _rvTask = findViewById<RecyclerView>(R.id.rvTask)
        SiapkanData()
        TambahData()
        TampilkanData()


        var _btnAdd = findViewById<Button>(R.id.btnAdd)
        _btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, addPage::class.java)
            startActivity(intent)
        }
    }

    private lateinit var _nama : MutableList<String>
    private lateinit var _tanggal : MutableList<String>
    private lateinit var _kategori : MutableList<String>
    private lateinit var _deskripsi : MutableList<String>

    private var arTask = arrayListOf<task>()
}