package com.c14220188.latihandaftarpekerjaan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class task(
    var nama : String,
    var tanggal : String,
    var kategori : String,
    var deskripsi : String
) : Parcelable
