package com.app.latihanrestapi.model.request


import com.google.gson.annotations.SerializedName

data class DataDetailMahasiswa(
    @SerializedName("NIM")
    val nIM: String,
    @SerializedName("Nama")
    val nama: String,
    @SerializedName("Telepon")
    val telepon: String
)