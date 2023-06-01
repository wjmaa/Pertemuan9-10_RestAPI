package com.app.latihanrestapi.network

import com.app.latihanrestapi.model.response.ResponseDataMahasiswa
import com.app.latihanrestapi.model.response.ResponseDetailDataMahasiswa
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("sub/restapi-slim/public/datamahasiswa/")
    fun getDataMahasiswa() : Call<ResponseDataMahasiswa>

    @GET("sub/restapi-slim/public/datamahasiswa/{nim}")
    fun getDetailMahasiswa(@Path("nim") nim : String) : Call<ResponseDetailDataMahasiswa>
}