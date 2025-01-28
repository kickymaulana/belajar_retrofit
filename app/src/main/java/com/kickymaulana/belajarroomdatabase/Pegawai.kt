package com.kickymaulana.belajarroomdatabase

import com.google.gson.annotations.SerializedName

data class Pegawai (
    @SerializedName("nama")
    val nama: String?,

    @SerializedName("alamat")
    val alamat: String?
)
