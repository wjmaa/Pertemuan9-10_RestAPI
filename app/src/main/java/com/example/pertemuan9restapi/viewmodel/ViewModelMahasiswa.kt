package com.example.pertemuan9restapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pertemuan9restapi.model.request.DataMahasiswa
import com.example.pertemuan9restapi.model.request.Mahasiswa
import com.example.pertemuan9restapi.model.response.ResponseAddMahasiswa
import com.example.pertemuan9restapi.model.response.ResponseDataMahasiswa
import com.example.pertemuan9restapi.model.response.ResponseDataUpdateMahasiswa
import com.example.pertemuan9restapi.model.response.ResponseDetailDataMahasiswa
import com.example.pertemuan9restapi.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelMahasiswa : ViewModel(){
    private val getDataMahasiswa = MutableLiveData<List<DataMahasiswa>?>()
    private val detailMahasiswa = MutableLiveData<ResponseDetailDataMahasiswa?>()
    private val insertMahasiswa = MutableLiveData<ResponseAddMahasiswa?>()
    private val updateMahasiswa = MutableLiveData<ResponseDataUpdateMahasiswa?>()

    fun getDataMahasiswa() : MutableLiveData<List<DataMahasiswa>?>{
        return getDataMahasiswa
    }
    fun getDetailMahasiswa(): MutableLiveData<ResponseDetailDataMahasiswa?> {
        return detailMahasiswa
    }
    fun insertMahasiswa(): MutableLiveData<ResponseAddMahasiswa?> {
        return insertMahasiswa
    }
    fun updateMahasiswa(): MutableLiveData<ResponseDataUpdateMahasiswa?> {
        return updateMahasiswa
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

    fun insertDataMahasiswa(nim : String, nama :String,telepon : String){
        ApiClient.instance.addDataMahasiswa(Mahasiswa(nim,nama,telepon)).enqueue(object : Callback<ResponseAddMahasiswa>{
            override fun onResponse(
                call: Call<ResponseAddMahasiswa>,
                response: Response<ResponseAddMahasiswa>
            ) {
                if (response.isSuccessful){
                    insertMahasiswa.postValue(response.body())
                }else{
                    insertMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseAddMahasiswa>, t: Throwable) {
                insertMahasiswa.postValue(null)
            }
        })
    }

    fun updateDataMahasiswa(nim : String, nama :String,telepon : String){
        ApiClient.instance.updateDataMahasiswa(nim,Mahasiswa(nim,nama,telepon)).enqueue(object : Callback<ResponseDataUpdateMahasiswa>{
            override fun onResponse(
                call: Call<ResponseDataUpdateMahasiswa>,
                response: Response<ResponseDataUpdateMahasiswa>
            ) {
                if (response.isSuccessful){
                    updateMahasiswa.postValue(response.body())
                }else{
                    updateMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDataUpdateMahasiswa>, t: Throwable) {
                updateMahasiswa.postValue(null)
            }
        })
    }
}
