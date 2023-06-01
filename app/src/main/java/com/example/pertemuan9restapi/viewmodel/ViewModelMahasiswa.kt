package com.example.pertemuan9restapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.latihanrestapi.model.request.DataMahasiswa
import com.app.latihanrestapi.model.response.ResponseDataMahasiswa
import com.app.latihanrestapi.model.response.ResponseDetailDataMahasiswa
import com.app.latihanrestapi.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelMahasiswa : ViewModel(){
    private val getDataMahasiswa = MutableLiveData<List<DataMahasiswa>?>()
    private val detailMahasiswa = MutableLiveData<ResponseDetailDataMahasiswa?>()

    fun getDataMahasiswa() : MutableLiveData<List<DataMahasiswa>?>{
        return getDataMahasiswa
    }
    fun getDetailMahasiswa(): MutableLiveData<ResponseDetailDataMahasiswa?> {
        return detailMahasiswa
    }

    fun showDataMahasiswa(){
        ApiClient.instance.getDataMahasiswa().enqueue(object : Callback<ResponseDataMahasiswa>{
            override fun onResponse(
                call: Call<ResponseDataMahasiswa>,
                response: Response<ResponseDataMahasiswa>)
            {
                if (response.isSuccessful){
                    getDataMahasiswa.postValue(response.body()?.data)
                }else{
                    getDataMahasiswa.postValue(null)
                }
            }
            override fun onFailure(call: Call<ResponseDataMahasiswa>,t: Throwable){
                getDataMahasiswa.postValue(null)
            }
        })
    }

    fun getDetailData(nim: String) {
        ApiClient.instance.getDetailMahasiswa(nim).enqueue(object : Callback<ResponseDetailDataMahasiswa> {
            override fun onResponse(
                call: Call<ResponseDetailDataMahasiswa>,
                response: Response<ResponseDetailDataMahasiswa>
            ) {
                if (response.isSuccessful) {
                    detailMahasiswa.postValue(response.body())
                } else {
                    detailMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDetailDataMahasiswa>, t: Throwable) {
                detailMahasiswa.postValue(null)
            }
        })
    }
}