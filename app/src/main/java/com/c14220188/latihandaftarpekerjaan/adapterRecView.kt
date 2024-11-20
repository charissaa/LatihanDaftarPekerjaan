package com.c14220188.latihandaftarpekerjaan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterRecView (private val listTask: ArrayList<task>) : RecyclerView.Adapter<adapterRecView.ListViewHolder> () {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _namaTask = itemView.findViewById<TextView>(R.id.namaTask)
        var _tanggalTask = itemView.findViewById<TextView>(R.id.tanggalTask)
        var _kategoriTask = itemView.findViewById<TextView>(R.id.kategoriTask)
        var _deskripsiTask = itemView.findViewById<TextView>(R.id.deskripsiTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.beranda_recycler, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var task = listTask[position]

        holder._namaTask.setText(task.nama)
        holder._tanggalTask.setText(task.tanggal)
        holder._kategoriTask.setText(task.kategori)
        holder._deskripsiTask.setText(task.deskripsi)
    }
}