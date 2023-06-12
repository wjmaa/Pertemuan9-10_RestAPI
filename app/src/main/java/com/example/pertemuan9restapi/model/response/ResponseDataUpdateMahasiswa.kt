package com.example.pertemuan9restapi.model.response

import com.google.gson.annotations.SerializedName

data class ResponseDataUpdateMahasiswa(
    @SerializedName("data")
    val data: String,
    @SerializedName("status")
    val status: String
)