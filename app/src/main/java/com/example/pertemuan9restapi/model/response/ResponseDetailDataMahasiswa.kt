package com.example.pertemuan9restapi.model.response


import com.example.pertemuan9restapi.model.request.DataDetailMahasiswa
import com.google.gson.annotations.SerializedName

data class ResponseDetailDataMahasiswa(
    @SerializedName("data")
    val data: DataDetailMahasiswa,
    @SerializedName("status")
    val status: String
)