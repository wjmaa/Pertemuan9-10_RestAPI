package com.app.latihanrestapi.model.response


import com.app.latihanrestapi.model.request.DataDetailMahasiswa
import com.google.gson.annotations.SerializedName

data class ResponseDetailDataMahasiswa(
    @SerializedName("data")
    val data: DataDetailMahasiswa,
    @SerializedName("status")
    val status: String
)